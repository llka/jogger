package ru.ilka.jogger.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ilka.jogger.entity.Workout;
import ru.ilka.jogger.service.UserService;
import ru.ilka.jogger.service.WorkoutService;
import ru.ilka.jogger.util.UrlSchema;

import java.util.List;

@RestController
@RequestMapping(value = UrlSchema.APP + "/workout", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkoutController {
    private static Logger logger = LogManager.getLogger(WorkoutController.class);

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @ApiOperation("This method allows to get workout by id.")
    public Workout getById(@PathVariable("id") Long id) {
        return workoutService.getById(id);
    }

    @GetMapping
    @ApiOperation("This method allows to get list of all workouts or list of workouts for certain user.")
    public List<Workout> getAll(@RequestParam(value = "userId", required = false) Long userId) {
        if (userId == null) {
            return workoutService.getAll();
        } else {
            return userService.getById(userId).getWorkouts();
        }
    }
}
