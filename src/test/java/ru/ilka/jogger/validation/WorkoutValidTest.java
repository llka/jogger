package ru.ilka.jogger.validation;

import org.junit.Assert;
import org.junit.Test;
import ru.ilka.jogger.entity.Workout;
import ru.ilka.jogger.util.MockEntityFactory;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class WorkoutValidTest extends ValidationTest {
    @Test
    public void whenValid_thenNoConstraintViolations() {
        Workout workout = MockEntityFactory.Workouts.running();

        Set<ConstraintViolation<Workout>> violations = validator.validate(workout);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void whenZeroDistance_thenConstraintViolation() {
        Workout workout = MockEntityFactory.Workouts.running();
        workout.setDistanceInKm(-1L);

        Set<ConstraintViolation<Workout>> violations = validator.validate(workout);
        Assert.assertNotEquals(0, violations.size());
    }

    @Test
    public void whenNullDate_thenConstraintViolation() {
        Workout workout = MockEntityFactory.Workouts.running();
        workout.setStartDateTime(null);
        workout.setFinishDateTime(null);

        Set<ConstraintViolation<Workout>> violations = validator.validate(workout);
        System.out.println(violations);
        Assert.assertNotEquals(0, violations.size());
    }
}
