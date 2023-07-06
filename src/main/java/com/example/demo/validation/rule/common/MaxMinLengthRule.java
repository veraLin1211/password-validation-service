package com.example.demo.validation.rule.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MaxMinLengthRule extends CommonValidationRules {

    private int maxLength;

    private int minLength;

    @Override
    public boolean validate(String password) {
        return pwdLongerThenMin(password) && pwdShorterThenMax(password);
    }

    private boolean pwdLongerThenMin(String password) {
        return password.length() >= minLength;
    }

    private boolean pwdShorterThenMax(String password) {
        return password.length() <= maxLength;
    }

}
