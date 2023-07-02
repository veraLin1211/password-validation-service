package com.example.demo.validation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LengthValidation implements PasswordValidation{

    @Value("${password-validation.length.min}")
    private int minLength;

    @Value("${password-validation.length.max}")
    private int maxLength;

    @Override
    public boolean validate(String password) {
        return  password.length() >= minLength && password.length() <= maxLength;
    }

}
