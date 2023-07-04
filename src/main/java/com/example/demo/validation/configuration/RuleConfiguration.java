package com.example.demo.validation.configuration;

import com.example.demo.constant.CharTypes;
import com.example.demo.validation.character.rule.DigitRules;
import com.example.demo.validation.character.rule.LowerCaseRules;
import com.example.demo.validation.character.rule.SymbolRules;
import com.example.demo.validation.character.rule.UpperCaseRules;
import com.example.demo.validation.common.MaxMinLengthRule;
import com.example.demo.validation.common.NoRepeatRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RuleConfiguration {

    @Value("${password-validation.char.enable-types}")
    private List<String> enableCharTypes;

    @Value("${password-validation.char.min.upper-case}")
    private int minUpperCaseChar;

    @Value("${password-validation.char.min.lower-case}")
    private int minLowerCaseChar;

    @Value("${password-validation.char.min.digit}")
    private int minDigitChar;

    @Value("${password-validation.char.min.symbol}")
    private int minSymbolChar;

    @Value("${password-validation.length.min}")
    private int minLength;

    @Value("${password-validation.length.max}")
    private int maxLength;

    @Bean
    public UpperCaseRules getUpperCaseRules() {
        CharTypes type = CharTypes.UPPER_CASE;
        boolean enable = isTypeEnable(type.name());
        return new UpperCaseRules(enable, minUpperCaseChar, type);
    }

    @Bean
    public LowerCaseRules getLowerCaseRules() {
        CharTypes type = CharTypes.LOWER_CASE;
        boolean enable = isTypeEnable(type.name());
        return new LowerCaseRules(enable, minLowerCaseChar, type);
    }

    @Bean
    public DigitRules getDigitRules() {
        CharTypes type = CharTypes.LOWER_CASE;
        boolean enable = isTypeEnable(type.name());
        return new DigitRules(enable, minLowerCaseChar, type);
    }

    @Bean
    public SymbolRules getSymbolRules() {
        CharTypes type = CharTypes.LOWER_CASE;
        boolean enable = isTypeEnable(type.name());
        return new SymbolRules(enable, minLowerCaseChar, type);
    }

    @Bean
    public MaxMinLengthRule getMaxMinLengthRule() {
        return new MaxMinLengthRule(maxLength, minLength);
    }

    @Bean
    public NoRepeatRule getNoRepeatRule() {
        return new NoRepeatRule();
    }

    private boolean isTypeEnable(String type) {
        return enableCharTypes.contains(type);
    }

}
