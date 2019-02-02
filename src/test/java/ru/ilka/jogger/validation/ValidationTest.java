package ru.ilka.jogger.validation;

import org.junit.BeforeClass;

import javax.validation.Validation;
import javax.validation.Validator;


public abstract class ValidationTest {
    protected static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}