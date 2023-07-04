package com.example.demo.validation.common;


public class NoRepeatRule extends CommonValidationRules {

    @Override
    public boolean validate(String password) {
        return noRepeatPattern(password);
    }

    public boolean noRepeatPattern(String str) {
            boolean result = true;
            if (str == null) {
                return false;
            }
            int len = str.length();
            for(int patternLen = 1; patternLen <= len/2; patternLen++){
                int firstPos = 0;
                int secondPos = patternLen;
                while(secondPos + patternLen <= len){
                    String first = str.substring(firstPos, firstPos+patternLen);
                    String second = str.substring(secondPos, secondPos+patternLen);
                    if(first.equals(second)) {
                        result = false;
                        break;
                    }
                    firstPos++;
                    secondPos++;
                }
                if(!result) break;
            }
        return result;
    }


}

