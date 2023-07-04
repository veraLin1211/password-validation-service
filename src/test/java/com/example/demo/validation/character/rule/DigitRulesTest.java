package com.example.demo.validation.character.rule;

import com.example.demo.validation.character.rule.DigitRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class DigitRulesTest {

    @Autowired
    private DigitRules rules;

    private final static String PWD_WITH_DIGITS = "abc123";

    private final static String PWD_WITHOUT_DIGITS = "abcefg";

    @Test
    public void password_should_have_digits() {
        Assertions.assertTrue(rules.validateAll(PWD_WITH_DIGITS));
    }

    @Test
    public void password_should_have_digits_but_not() {
        Assertions.assertFalse(rules.validateAll(PWD_WITHOUT_DIGITS));
    }

}