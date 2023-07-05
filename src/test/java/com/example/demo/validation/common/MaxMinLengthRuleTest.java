package com.example.demo.validation.common;

import com.example.demo.configuration.GlobalConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
@ContextConfiguration(classes = GlobalConfiguration.class)
public class MaxMinLengthRuleTest {

    @Autowired
    private MaxMinLengthRule rule;

    final static String PWD_TOO_LONG = "abcdefghi12345";

    final static String PWD_TOO_SHORT = "ab12";

    final static String PWD_VALID_LENGTH = "abc123";

    @Test
    public void password_valid_length() {
        Assertions.assertTrue(rule.validate(PWD_VALID_LENGTH));
    }

    @Test
    public void password_too_long() {
        Assertions.assertFalse(rule.validate(PWD_TOO_LONG));
    }

    @Test
    public void password_too_short() {
        Assertions.assertFalse(rule.validate(PWD_TOO_SHORT));
    }

}
