package ru.ilka.jogger.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ilka.jogger.dto.PeriodDTO;
import ru.ilka.jogger.dto.UserAverageWorkoutReportDTO;
import ru.ilka.jogger.dto.WorkoutAverageReportDTO;
import ru.ilka.jogger.entity.User;
import ru.ilka.jogger.entity.Workout;
import ru.ilka.jogger.mapper.UserDOtoDTOmapper;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private static Logger logger = LogManager.getLogger(ReportService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WorkoutService workoutService;

    public List<UserAverageWorkoutReportDTO> getAverageReportsByWeeks() {
        List<User> users = userService.getAll();
        List<UserAverageWorkoutReportDTO> userAverageWorkoutReportDTOList = new ArrayList<>(users.size());
        for (User user : users) {
            UserAverageWorkoutReportDTO userAverageWorkoutReportDTO = new UserAverageWorkoutReportDTO();
            userAverageWorkoutReportDTO.setUser(UserDOtoDTOmapper.mapUser(user));

            List<Workout> workouts = user.getWorkouts();

            Map<Integer, List<Workout>> workoutsByWeeks = workouts.stream()
                    .filter(w -> w.getStartDateTime() != null)
                    .collect(Collectors.groupingBy(w -> getWeekNumber(w.getStartDateTime())));

            List<WorkoutAverageReportDTO> workoutAverageReportList = new ArrayList<>();

            workoutsByWeeks.forEach((weekNumber, weekWorkouts) -> {
                WorkoutAverageReportDTO workoutAverageReport = new WorkoutAverageReportDTO();
                PeriodDTO period = new PeriodDTO();
                period.setStartDate(getWeekStartDate(weekNumber));
                period.setEndDate(getWeekEndDate(weekNumber));
                workoutAverageReport.setPeriod(period);

                workoutAverageReport.setTotalDistanceInKm(weekWorkouts.stream().mapToLong(Workout::getDistanceInKm).sum());
                workoutAverageReport.setAverageDistanceInKm(workoutAverageReport.getTotalDistanceInKm() / weekWorkouts.size());
                workoutAverageReport.setAverageSpeedKmH(weekWorkouts.stream().mapToDouble(Workout::getAverageSpeedKmH).sum() / weekWorkouts.size());
                workoutAverageReport.setAverageWorkoutTimeLengthInMin(((double) weekWorkouts.stream().mapToInt(Workout::getLengthInHours).sum()) / ((double) weekWorkouts.size()));
                workoutAverageReportList.add(workoutAverageReport);
            });
            userAverageWorkoutReportDTO.setWorkoutsByPeriods(workoutAverageReportList);
            userAverageWorkoutReportDTOList.add(userAverageWorkoutReportDTO);
        }
        return userAverageWorkoutReportDTOList;
    }

    private int getWeekNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    private Date getWeekStartDate(int weekNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_YEAR, weekNumber);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    private Date getWeekEndDate(int weekNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_YEAR, weekNumber);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }


}
