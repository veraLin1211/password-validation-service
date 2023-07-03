package com.example.demo.validation.other;

import com.example.demo.validation.PasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OtherValidation implements PasswordValidation {

    @Autowired
    private List<OtherValidationRules> rules;

    @Override
    public boolean validate(String password) {
        List<Boolean> results = rules.stream().map(it -> {
            return it.validate(password);
        }).collect(Collectors.toList());
        return !results.contains(false);
    }

}
