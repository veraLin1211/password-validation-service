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
       for(CharValidationRules rules : rules) {
           boolean isValid = rules.validateAll(password);
           if(!isValid) return false;
       }
       return true;
   }

}
