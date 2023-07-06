package com.example.demo.validation.rule.character.constant;

import com.example.demo.configuration.GlobalConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ContextConfiguration(classes = GlobalConfiguration.class)
@TestPropertySource(locations="classpath:test.properties")
public class CharTypeTest {

    private final static char UPPER_CASE_CHAR = 'A';

    private final static char LOWER_CASE_CHAR = 'a';

    private final static char DIGIT_CHAR = '1';

    private final static char SYMBOL_CHAR = '%';

    @Test
    public void match_upper_case() {
        Assertions.assertTrue(CharType.UPPER_CASE.matchCharType(UPPER_CASE_CHAR));
    }

    @Test
    public void match_lower_case() {
        Assertions.assertTrue(CharType.LOWER_CASE.matchCharType(LOWER_CASE_CHAR));
    }

    @Test
    public void match_digit() {
        Assertions.assertTrue(CharType.DIGIT.matchCharType(DIGIT_CHAR));
    }

    @Test
    public void match_symbol() {
        Assertions.assertTrue(CharType.SYMBOL.matchCharType(SYMBOL_CHAR));
    }
}
