package com.example.demo.validation.character.rule.evaluation;

import com.example.demo.validation.character.model.dto.CharConfig;

public interface Evaluation {

    boolean evaluate(String password, CharConfig config);

}
