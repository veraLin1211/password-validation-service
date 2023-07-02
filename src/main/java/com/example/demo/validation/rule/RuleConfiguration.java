package com.example.demo.validation.rule;

import com.example.demo.constant.CharTypes;
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

    private boolean isTypeEnable(String type) {
        return enableCharTypes.contains(type);
    }

}
