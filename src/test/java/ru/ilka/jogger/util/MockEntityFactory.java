package ru.ilka.jogger.util;

import ru.ilka.jogger.entity.Role;
import ru.ilka.jogger.entity.User;
import ru.ilka.jogger.entity.Workout;

import java.util.Date;

public class MockEntityFactory {
    public static class Users {
        public static User bob() {
            User user = new User();
            user.setId(1L);
            user.setRole(Role.USER);
            user.setPassword("12345");
            user.setLogin("1234");
            return user;
        }
    }

    public static class Workouts {
        public static Workout running() {
            Workout workout = new Workout();
            workout.setId(1L);
            workout.setDistanceInKm(12L);
            workout.setStartDateTime(new Date());
            workout.setFinishDateTime(new Date());
            return workout;
        }

    }
}
