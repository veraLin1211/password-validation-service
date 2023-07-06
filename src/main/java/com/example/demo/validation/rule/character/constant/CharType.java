package com.example.demo.validation.rule.character.constant;

import lombok.Getter;

@Getter
public enum CharType {
    UPPER_CASE(".*[A-Z].*") {
        @Override
        public boolean matchCharType(char c) {
            return Character.isUpperCase(c);
        }
    },
    LOWER_CASE(".*[a-z].*") {
        @Override
        public boolean matchCharType(char c) {
            return Character.isLowerCase(c);
        }
    },
    DIGIT(".*\\d.*") {
        @Override
        public boolean matchCharType(char c) {
            return Character.isDigit(c);
        }
    },
    SYMBOL(".*\\W.*") {
        @Override
        public boolean matchCharType(char c) {
            return !Character.isLetter(c) && !Character.isDigit(c)
                    && !Character.isWhitespace(c);
        }
    };

    private final String regexPattern;

    CharType(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public abstract boolean matchCharType(char c);

}