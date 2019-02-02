package ru.ilka.jogger.validation;

import org.junit.Assert;
import org.junit.Test;
import ru.ilka.jogger.entity.User;
import ru.ilka.jogger.util.MockEntityFactory;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class UserValidTest extends ValidationTest {
    @Test
    public void whenValid_thenNoConstraintViolations() {
        User user = MockEntityFactory.Users.bob();

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void whenToShortPassword_thenConstraintViolation() {
        User user = MockEntityFactory.Users.bob();
        user.setPassword("22");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void whenToShortLogin_thenConstraintViolation() {
        User user = MockEntityFactory.Users.bob();
        user.setLogin("1");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
    }
}
