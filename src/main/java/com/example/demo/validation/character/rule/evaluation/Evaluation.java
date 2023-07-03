package com.example.demo.validation.character.rule.evaluation;

import com.example.demo.validation.character.rule.CharValidationRules;

public interface Evaluation {

    public boolean evaluate(String password, CharValidationRules rule);

}
