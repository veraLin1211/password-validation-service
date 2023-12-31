package com.example.demo.configuration;

import com.example.demo.validation.impl.CharValidation;
import com.example.demo.validation.rule.character.constant.CharType;
import com.example.demo.validation.rule.character.DigitRules;
import com.example.demo.validation.rule.character.LowerCaseRules;
import com.example.demo.validation.rule.character.SymbolRules;
import com.example.demo.validation.rule.character.UpperCaseRules;
import com.example.demo.validation.rule.character.evaluation.impl.EnableEvaluation;
import com.example.demo.validation.rule.character.evaluation.impl.MinCountEvaluation;
import com.example.demo.validation.impl.CommonValidation;
import com.example.demo.validation.rule.common.MaxMinLengthRule;
import com.example.demo.validation.rule.common.NoRepeatRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GlobalConfiguration {

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
        CharType type = CharType.UPPER_CASE;
        boolean enable = isTypeEnable(type.name());
        return new UpperCaseRules(enable, minUpperCaseChar, type);
    }

    @Bean
    public LowerCaseRules getLowerCaseRules() {
        CharType type = CharType.LOWER_CASE;
        boolean enable = isTypeEnable(type.name());
        return new LowerCaseRules(enable, minLowerCaseChar, type);
    }

    @Bean
    public DigitRules getDigitRules() {
        CharType type = CharType.DIGIT;
        boolean enable = isTypeEnable(type.name());
        return new DigitRules(enable, minDigitChar, type);
    }

    @Bean
    public SymbolRules getSymbolRules() {
        CharType type = CharType.SYMBOL;
        boolean enable = isTypeEnable(type.name());
        return new SymbolRules(enable, minSymbolChar, type);
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

    @Bean
    public CharValidation getCharValidation() {
        return new CharValidation();
    }

    @Bean
    public CommonValidation getCommonValidation() {
        return new CommonValidation();
    }

    @Bean
    public MinCountEvaluation getMinCountEvaluation() {
        return new MinCountEvaluation();
    }

    @Bean
    public EnableEvaluation getEnableEvaluation() {
        return new EnableEvaluation();
    }

}
