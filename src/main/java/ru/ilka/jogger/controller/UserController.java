package ru.ilka.jogger.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ilka.jogger.entity.User;
import ru.ilka.jogger.entity.Workout;
import ru.ilka.jogger.service.UserService;
import ru.ilka.jogger.util.UrlSchema;

import java.util.List;

@RestController
@RequestMapping(value = UrlSchema.APP + "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @ApiOperation("This method allows to get user by id.")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/me")
    @ApiOperation("This method allows to get current user.")
    public User getById() {
        return userService.getCurrentUser();
    }

    @GetMapping
    @ApiOperation("This method allows to get all users.")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("This method allows to update user by id.")
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.update(user, id);
    }

    @PutMapping(value = "/{id}/addworkout", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("This method allows to add new workout to the certain user by user id.")
    public User addWorkout(@PathVariable("id") Long id, @RequestBody Workout workout) {
        return userService.addWorkout(workout, id);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("This method allows to remove user by id.")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @DeleteMapping
    @ApiOperation("This method allows to remove all users.")
    public void deleteAll() {
        userService.deleteAll();
    }
}
