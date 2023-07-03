package com.example.demo.validation.character.rule.evaluation;

import com.example.demo.constant.CharTypes;
import com.example.demo.validation.character.rule.CharValidationRules;
import org.springframework.stereotype.Component;

@Component
public class MinCountEvaluation implements Evaluation {

    @Override
    public boolean evaluate(String password, CharValidationRules rule) {
        System.out.println("evaluate min count");
        int minCount = rule.getMinCount();
        System.out.println("min count: " + minCount);
        int matchCount = 0;
        int idx = 0;
        char[] charArr = password.toCharArray();
        while((minCount > 0 && matchCount <= minCount) && idx < charArr.length - 1) {
            if(matchCharType(rule.getChartType(), charArr[idx])) {
                matchCount ++;
            }
            idx ++;
        }
        return minCount < 0 || matchCount >= minCount;
    }

    private boolean matchCharType(CharTypes chartType, char c) {
        return chartType.matchCharType(c);
    }

}
