package com.example.demo.validation.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoRepeatRuleTest {

    @Autowired
    private NoRepeatRule rule;

    private static final String PWD_WITH_REPEAT_CHAR = "abcdcd123";

    private static final String PWD_WITHOUT_REPEAT_CHAR = "abcd123";

    private static final String PWD_IS_NULL = null;

    @Test
    public void password_without_repeat_char() {
        Assertions.assertTrue(rule.validate(PWD_WITHOUT_REPEAT_CHAR));
    }

    @Test
    public void password_with_repeat_chart() {
        Assertions.assertFalse(rule.validate(PWD_WITH_REPEAT_CHAR));
    }

    @Test
    public void password_is_null() {
        Assertions.assertFalse(rule.validate(PWD_IS_NULL));
    }

}
