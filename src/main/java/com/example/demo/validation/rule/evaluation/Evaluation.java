package com.example.demo.validation.rule.evaluation;

import com.example.demo.validation.rule.CharValidationRules;

public interface Evaluation {

    public boolean evaluate(String password, CharValidationRules rule);

}
