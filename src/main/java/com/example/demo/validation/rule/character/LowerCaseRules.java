package com.example.demo.validation.rule.character;


import com.example.demo.validation.rule.character.constant.CharType;

public class LowerCaseRules extends CharValidationRules {

    public LowerCaseRules(boolean enable, int minCount, CharType chartType) {
        super(enable, minCount, chartType);
    }

}
