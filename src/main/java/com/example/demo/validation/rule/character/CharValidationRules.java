package com.example.demo.validation.rule.character;

import com.example.demo.validation.rule.character.constant.CharType;
import com.example.demo.validation.rule.character.model.dto.CharConfig;
import com.example.demo.validation.rule.character.evaluation.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CharValidationRules {

    @Autowired
    private List<Evaluation> evaluations;

    public CharValidationRules(boolean enable, int minCount, CharType chartType) {
        this.enable = enable;
        this.minCount = minCount;
        this.chartType = chartType;
    }

    private boolean enable;

    private int minCount;

    private CharType chartType;

    public boolean validateAll(String password) {
        for(Evaluation evaluation : evaluations) {
            CharConfig config = new CharConfig(this.chartType, this.enable, this.minCount);
            boolean isValid = evaluation.evaluate(password, config);
            if(!isValid) return false;
        }
        return true;
    }

}
