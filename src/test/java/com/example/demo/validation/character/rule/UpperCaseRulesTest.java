package com.example.demo.validation.character.rule;

import com.example.demo.configuration.GlobalConfiguration;
import com.example.demo.validation.character.rule.UpperCaseRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
@ContextConfiguration(classes = GlobalConfiguration.class)
public class UpperCaseRulesTest {

    @Autowired
    private UpperCaseRules rules;

    private final static String PWD_WITHOUT_UPPER_CASE = "abcefg123";

    private final static String PWD_WITH_UPPER_CASE = "ABC123";

    @Test
    public void password_should_not_have_upper_case() {
        Assertions.assertTrue(rules.validateAll(PWD_WITHOUT_UPPER_CASE));
    }

    @Test
    public void password_should_not_have_upper_case_but_yes() {
        Assertions.assertFalse(rules.validateAll(PWD_WITH_UPPER_CASE));
    }

}
