package com.example.demo.annotation;

import com.example.demo.validation.PasswordValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidator implements ConstraintValidator<ValidatePassword, String> {

    @Autowired
    private List<PasswordValidation> validations;

    @Override
    public void initialize(ValidatePassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Boolean> results = validations.stream().map(it -> {
            return it.validate(value);
        }).collect(Collectors.toList());
        return !results.contains(false);
    }
}
