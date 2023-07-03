package com.example.demo.validation.character;

import com.example.demo.validation.PasswordValidation;
import com.example.demo.validation.character.rule.CharValidationRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
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
