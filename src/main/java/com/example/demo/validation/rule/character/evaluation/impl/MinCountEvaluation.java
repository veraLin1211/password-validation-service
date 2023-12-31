package com.example.demo.validation.rule.character.evaluation.impl;

import com.example.demo.validation.rule.character.evaluation.Evaluation;
import com.example.demo.validation.rule.character.model.dto.CharConfig;

public class MinCountEvaluation implements Evaluation {

    @Override
    public boolean evaluate(String password, CharConfig config) {
        if(!charIsEnabled(config)) return true;
        return pwdHasEnoughMatch(password, config);
    }

    private boolean pwdHasEnoughMatch(String password, CharConfig config) {
        int minCount = config.getMinCount();
        int matchCount = 0;
        int idx = 0;
        char[] charArr = password.toCharArray();
        while(!reachedMinCount(matchCount, minCount) && idx < charArr.length - 1) {
            matchCount += getOneIfMatch(config, charArr[idx]);
            idx ++;
        }
        return reachedMinCount(matchCount, minCount);
    }

    private boolean reachedMinCount(int match, int min) {
        return match >= min;
    }

    private int getOneIfMatch(CharConfig config, char c) {
        return config.getCharType().matchCharType(c) ? 1 : 0;
    }

}
