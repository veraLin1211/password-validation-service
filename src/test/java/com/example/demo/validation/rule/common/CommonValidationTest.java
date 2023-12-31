package com.example.demo.validation.rule.common;

import com.example.demo.configuration.GlobalConfiguration;
import com.example.demo.validation.impl.CommonValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
@ContextConfiguration(classes = GlobalConfiguration.class)
public class CommonValidationTest {

    @Autowired
    private CommonValidation validation;

    final static String PWD_ALL_VALID = "abcdefg";

    final static String PWD_NOT_ALL_VALID = "abab";

    @Test
    public void password_all_valid() {
        Assertions.assertTrue(validation.validate(PWD_ALL_VALID));
    }

    @Test
    public void password_has_rule_not_passed() {
        Assertions.assertFalse(validation.validate(PWD_NOT_ALL_VALID));
    }

}
