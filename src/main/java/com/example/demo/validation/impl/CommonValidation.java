package com.example.demo.validation.impl;

import com.example.demo.PasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CommonValidation implements PasswordValidation {

    @Autowired
    private List<CommonValidationRules> rules;

    @Override
    public boolean validate(String password) {
        List<Boolean> results = rules.stream().map(it -> {
            return it.validate(password);
        }).collect(Collectors.toList());
        return isAllValid(results);
    }

    private boolean isAllValid(List<Boolean> results) {
        return !results.contains(false);
    }

}
