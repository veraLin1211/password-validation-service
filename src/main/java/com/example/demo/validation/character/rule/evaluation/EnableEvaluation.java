package com.example.demo.validation.character.rule.evaluation;

import com.example.demo.validation.character.model.dto.CharConfig;

public class EnableEvaluation implements Evaluation {

    @Override
    public boolean evaluate(String password, CharConfig config) {
        return noInvalidCharacter(password, config);
    }

    private boolean noInvalidCharacter(String password, CharConfig config) {
        if(config.isEnable()) {
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
