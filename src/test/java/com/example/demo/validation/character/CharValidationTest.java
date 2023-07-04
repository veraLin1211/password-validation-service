package com.example.demo.validation.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class CharValidationTest {

    @Autowired
    private CharValidation validation;

    private static final String PWD_ALL_VALID = "abc123";

    private static final String PWD_WITH_UPPER_CASE = "abcABC123";

    @Test
    public void password_pass_all_rules() {
        Assertions.assertTrue(validation.validate(PWD_ALL_VALID));
    }

    @Test
    public void password_some_rule_not_passed() {
        Assertions.assertFalse(validation.validate(PWD_WITH_UPPER_CASE));
    }
}
