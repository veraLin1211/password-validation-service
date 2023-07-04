package com.example.demo.validation.character.rule;

import com.example.demo.validation.character.constant.CharType;
import com.example.demo.validation.character.model.dto.CharConfig;
import com.example.demo.validation.character.rule.evaluation.Evaluation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public abstract class CharValidationRules {

    @Autowired
    List<Evaluation> evaluations;

    public CharValidationRules(boolean enable, int minCount, CharType chartType) {
        this.enable = enable;
        this.minCount = minCount;
        this.chartType = chartType;
    }

    boolean enable;

    int minCount;

    String regexPattern;

    CharTypes chartType;

    public boolean validateAll(String password) {
        List<Boolean> results = evaluations.stream().map(it -> {
            return it.evaluate(password, this);
        }).collect(Collectors.toList());
        return !results.contains(false);
    }

}
