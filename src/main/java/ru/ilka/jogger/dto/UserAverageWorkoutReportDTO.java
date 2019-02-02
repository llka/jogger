package ru.ilka.jogger.dto;

import java.util.List;

public class UserAverageWorkoutReportDTO {
    private UserDTO user;
    private List<WorkoutAverageReportDTO> workoutsByPeriods;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<WorkoutAverageReportDTO> getWorkoutsByPeriods() {
        return workoutsByPeriods;
    }

    public void setWorkoutsByPeriods(List<WorkoutAverageReportDTO> workoutsByPeriods) {
        this.workoutsByPeriods = workoutsByPeriods;
    }
}
