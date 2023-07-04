package com.example.demo.validation.character.rule;

import com.example.demo.validation.character.constant.CharType;
import com.example.demo.validation.character.model.dto.CharConfig;
import com.example.demo.validation.character.rule.evaluation.Evaluation;
import lombok.Getter;
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
        List<Boolean> results = evaluations.stream().map(it -> {
            CharConfig config = new CharConfig(this.chartType, this.enable, this.minCount);
            return it.evaluate(password, config);
        }).collect(Collectors.toList());
        return isAllValid(results);
    }

    private boolean isAllValid(List<Boolean> results) {
        return !results.contains(false);
    }

}
