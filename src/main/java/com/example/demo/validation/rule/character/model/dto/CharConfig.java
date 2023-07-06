package com.example.demo.validation.rule.character.model.dto;

import com.example.demo.validation.rule.character.constant.CharType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CharConfig {

    private CharType charType;

    private boolean isEnable;

    private int minCount;

}
