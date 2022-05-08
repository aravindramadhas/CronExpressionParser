package com.cronexpressionparser.utils;

public class StringUtils {
    private static final int LABEL_LENGTH = 14;

    public static boolean isNumeric(String value){
        return value.chars().allMatch( Character::isDigit );
    }

    public static String appendLabel(String str){
        int spaceLength = LABEL_LENGTH - str.length();
        StringBuilder sb = new StringBuilder(str);
        while(spaceLength>0){
            sb.append(" ");
            spaceLength--;
        }
        return sb.toString();
    }
}
