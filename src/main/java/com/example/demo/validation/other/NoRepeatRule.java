package com.example.demo.validation.other;


public class NoRepeatRule extends OtherValidationRules{

    @Override
    public boolean validate(String password) {
        return !hasRepeatedPattern(password);
    }

    public boolean hasRepeatedPattern(String str) {
            boolean result = false;
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
                        result = true;
                        break;
                    }
                    firstPos++;
                    secondPos++;
                }
                if(result) break;
            }
        return result;
    }


}

