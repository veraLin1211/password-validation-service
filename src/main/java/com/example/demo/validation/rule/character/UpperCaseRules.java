package com.example.demo.validation.rule.character;


import com.example.demo.validation.rule.character.constant.CharType;

public class UpperCaseRules extends CharValidationRules {

    public UpperCaseRules(boolean enable, int minCount, CharType chartType) {
        super(enable, minCount, chartType);
    }

}
