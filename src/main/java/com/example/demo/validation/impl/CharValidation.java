package com.example.demo.validation.impl;

import com.example.demo.PasswordValidation;
import com.example.demo.validation.rule.character.CharValidationRules;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CharValidation implements PasswordValidation {

   @Autowired
   private List<CharValidationRules> rules;

   @Override
   public boolean validate(String password) {
       List<Boolean> results = rules.stream().map(rule -> {
           return rule.validateAll(password);
       }).collect(Collectors.toList());
       return !results.contains(false);
   }

}
