package com.example.demo.validation.impl;

import com.example.demo.PasswordValidation;
import com.example.demo.validation.rule.common.CommonValidationRules;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonValidation implements PasswordValidation {

    @Autowired
    private List<CommonValidationRules> rules;

    @Override
    public boolean validate(String password) {
        for(CommonValidationRules rule : rules) {
            boolean isValid = rule.validate(password);
            if(!isValid) return false;
        }
        return true;
    }

}
