package com.example.demo.validation.other;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MaxMinLengthRule extends OtherValidationRules {

    private int maxLength;

    private int minLength;

    @Override
    public boolean validate(String password) {
        return password.length() >= minLength && password.length() <= maxLength;
    }

}
