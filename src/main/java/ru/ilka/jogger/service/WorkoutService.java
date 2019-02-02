package ru.ilka.jogger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ilka.jogger.entity.Workout;
import ru.ilka.jogger.exception.RestExceptionNotFound;
import ru.ilka.jogger.repository.WorkoutRepository;

import java.util.Date;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> getAll() {
        return workoutRepository.findAll();
    }

    public Workout getById(Long id) {
        return workoutRepository.findById(id).orElseThrow(RestExceptionNotFound::new);
    }

    public List<Workout> findWorkoutsBetweenStartDates(Date startDateMin, Date startDateMax) {
        return workoutRepository.findByStartDateTimeBetween(startDateMin, startDateMax);
    }


}
