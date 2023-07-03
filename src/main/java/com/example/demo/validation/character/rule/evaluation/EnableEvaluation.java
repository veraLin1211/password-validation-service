package com.example.demo.validation.character.rule.evaluation;

import com.example.demo.validation.character.rule.CharValidationRules;
import org.springframework.stereotype.Component;

@Component
public class EnableEvaluation implements Evaluation {

    @Override
    public boolean evaluate(String password, CharValidationRules rule) {
        System.out.println("evaluate enable");
        if(!rule.isEnable()) {
            return !password.matches(rule.getRegexPattern());
        }
        return true;
    }

}
