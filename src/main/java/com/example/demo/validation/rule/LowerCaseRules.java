package com.example.demo.validation.rule;


import com.example.demo.constant.CharTypes;

public class LowerCaseRules extends CharValidationRules {

    public LowerCaseRules(boolean enable, int minCount, CharTypes chartType) {
        super(enable, minCount, chartType);
    }

}
