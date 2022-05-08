package com.cronexpressionparser.utils;

import com.cronexpressionparser.constants.AllowedSpecialCharacters;
import com.cronexpressionparser.expression.field.datetime.DateTimeField;

public class DateTimeValueGenerator {

    public static String generateAsteriskVals(DateTimeField field){
        StringBuilder sb = new StringBuilder();
        for(int i= field.getRange().getFromValue(); i <=field.getRange().getToValue(); i++){
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String generateCommaVals(DateTimeField field){
        String split[] = field.getValue().split(AllowedSpecialCharacters.COMMA);
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i <split.length; i++) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String generateDashVals(DateTimeField field){
        String split[] = field.getValue().split(AllowedSpecialCharacters.DASH);
        int from = Integer.parseInt(split[0]);
        int to = Integer.parseInt(split[1]);
        StringBuilder sb = new StringBuilder();
        for(int i= from; i <=to; i++) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String generateSlashVals(DateTimeField field){
        String split[] = field.getValue().split(AllowedSpecialCharacters.SLASH);
        int from = split[0].equals(AllowedSpecialCharacters.ASTERISK) ? field.getRange().getFromValue() :Integer.parseInt(split[0]);
        int step = Integer.parseInt(split[1]);
        StringBuilder sb = new StringBuilder();
        for(int i= from; i <= field.getRange().getToValue() ; i=i+step) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }

}
