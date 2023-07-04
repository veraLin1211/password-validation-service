package com.example.demo.validation.character.rule.evaluation;

import com.example.demo.validation.character.model.dto.CharConfig;
import org.springframework.stereotype.Component;

@Component
public class EnableEvaluation implements Evaluation {

    @Override
    public boolean evaluate(String password, CharConfig config) {
        if(config.isEnable()) {
            return true;
        } else {
            return passwordNotMatchPattern(password, config);
        }
    }

    private boolean passwordNotMatchPattern(String password, CharConfig config) {
        String pattern = getRegexPattern(config);
        return !password.matches(pattern);
    }

    private String getRegexPattern(CharConfig config) {
        return config.getCharType().getRegexPattern();
    }

}
