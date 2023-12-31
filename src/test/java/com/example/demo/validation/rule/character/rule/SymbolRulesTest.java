package com.example.demo.validation.rule.character.rule;

import com.example.demo.configuration.GlobalConfiguration;
import com.example.demo.validation.rule.character.SymbolRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
@ContextConfiguration(classes = GlobalConfiguration.class)
public class SymbolRulesTest {

    @Autowired
    private SymbolRules rules;

    private final static String PWD_WITHOUT_SYMBOL = "abcefg123";

    private final static String PWD_WITH_SYMBOL = "ABC123%^&";

    @Test
    public void password_should_not_have_symbol() {
        Assertions.assertTrue(rules.validateAll(PWD_WITHOUT_SYMBOL));
    }

    @Test
    public void password_should_not_have_symbol_but_yes() {
        Assertions.assertFalse(rules.validateAll(PWD_WITH_SYMBOL));
    }

}
