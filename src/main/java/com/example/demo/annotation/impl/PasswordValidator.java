package com.example.demo.annotation.impl;

import com.example.demo.PasswordValidation;
import com.example.demo.annotation.ValidatePassword;
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
        for(PasswordValidation validation : validations) {
            boolean isValid = validation.validate(value);
            if(!isValid) return false;
        }
        return true;
    }
}
