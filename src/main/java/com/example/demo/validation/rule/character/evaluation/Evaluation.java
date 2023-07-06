package com.example.demo.validation.rule.character.evaluation;

import com.example.demo.validation.rule.character.model.dto.CharConfig;

public interface Evaluation {

    default boolean charIsEnabled(CharConfig config) {
        return config.isEnable();
    }

    boolean evaluate(String password, CharConfig config);

}
