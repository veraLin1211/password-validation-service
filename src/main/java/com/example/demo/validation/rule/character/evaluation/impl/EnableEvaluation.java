package com.example.demo.validation.rule.character.evaluation.impl;

import com.example.demo.validation.rule.character.evaluation.Evaluation;
import com.example.demo.validation.rule.character.model.dto.CharConfig;

public class EnableEvaluation implements Evaluation {

    @Override
    public boolean evaluate(String password, CharConfig config) {
        return noInvalidCharacter(password, config);
    }

    private boolean noInvalidCharacter(String password, CharConfig config) {
        if(charIsEnabled(config)) {
            return true;
        } else {
            return checkPwdNotMatchPattern(password, config);
        }
    }

    private boolean checkPwdNotMatchPattern(String password, CharConfig config) {
        String pattern = getRegexPattern(config);
        return !password.matches(pattern);
    }

    private String getRegexPattern(CharConfig config) {
        return config.getCharType().getRegexPattern();
    }

}
