package com.example.demo.validation.rule.common;


public class NoRepeatRule extends CommonValidationRules {

    @Override
    public boolean validate(String password) {
        return noRepeatPattern(password);
    }

    public static boolean noRepeatPattern(String str) {
        if (str == null) {
            return false;
        }
        int len = str.length();
        for(int patternLen = 1; patternLen <= len/2; patternLen++){
            String[] chunks = str.split("(?<=\\G.{" + patternLen + "})");
            for(int j = 0; j < chunks.length - 1 ; j++){
                if(chunks[j].equals(chunks[j+1])){
                    return false;
                }
            }
        }
        return true;
    }


}

