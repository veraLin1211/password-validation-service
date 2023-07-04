package com.example.demo.validation.character.rule.evaluation;

import com.example.demo.validation.character.model.dto.CharConfig;
import org.springframework.stereotype.Component;

@Component
public class MinCountEvaluation implements Evaluation {

    @Override
    public boolean evaluate(String password, CharConfig config) {
        int minCount = config.getMinCount();
        int matchCount = 0;
        int idx = 0;
        char[] charArr = password.toCharArray();
        while(matchCount <= minCount && idx < charArr.length - 1) {
            if(matchCharType(config, charArr[idx])) {
                matchCount ++;
            }
            idx ++;
        }
        return matchCount >= minCount;
    }

    private boolean matchCharType(CharConfig config, char c) {
        return config.getCharType().matchCharType(c);
    }

}
