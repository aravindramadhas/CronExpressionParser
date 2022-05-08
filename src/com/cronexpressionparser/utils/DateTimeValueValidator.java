package com.cronexpressionparser.utils;

import com.cronexpressionparser.constants.AllowedSpecialCharacters;
import com.cronexpressionparser.exceptions.InvalidInputException;
import com.cronexpressionparser.exceptions.RangeOutOfBoundException;
import com.cronexpressionparser.expression.field.datetime.DateTimeField;
import com.cronexpressionparser.expression.field.datetime.Range;

public class DateTimeValueValidator {

    public static void validateNumber(DateTimeField field) throws RangeOutOfBoundException {
        Integer valInt = Integer.parseInt(field.getValue());
        if(!field.getRange().encloses(valInt)){
            throw new RangeOutOfBoundException("The value " + valInt + " does not lie within the range " + field.getRange().toString());
        }
    }

    public static void validateCharacter(DateTimeField field){
            if(!AllowedSpecialCharacters.ASTERISK.equals(field.getValue())){
                throw new InvalidInputException("The given value " + field.getValue() + " is invalid");
            }
    }

    public static void validateComma(DateTimeField field) throws RangeOutOfBoundException {
        String value = field.getValue();
        Range range = field.getRange();
        String split[] = value.split(",");
        for(String str : split){
            if(!StringUtils.isNumeric(str))
                throw new InvalidInputException("The given value " + value + " is invalid");

            int val = Integer.parseInt(str);
            if(!range.encloses(val))
                throw new RangeOutOfBoundException("The value " + str + " does not lie within the range " + range.toString());
        }
    }

    public static void validateDash(DateTimeField field) throws RangeOutOfBoundException {
        String value = field.getValue();
        Range range = field.getRange();
        String split[] = value.split("-");
        if(split.length != 2)
            throw new InvalidInputException("The given value " + value + " is invalid");
        for(String str : split){
            if(!StringUtils.isNumeric(str))
                throw new InvalidInputException("The given value " + value + " is invalid");
            else if(!range.encloses(Integer.parseInt(str)))
                throw new RangeOutOfBoundException("The value " + str + " does not lie within the range " + range.toString());

        }
    }

    public static void validateSlash(DateTimeField field){
        String value = field.getValue();
        String split[] = value.split("/");
        if(split.length != 2  || (!StringUtils.isNumeric(split[0]) && !split[0].equals(AllowedSpecialCharacters.ASTERISK))
        || !StringUtils.isNumeric(split[1])){
            throw new InvalidInputException("The given value " + value + " is invalid");
        }
    }

}
