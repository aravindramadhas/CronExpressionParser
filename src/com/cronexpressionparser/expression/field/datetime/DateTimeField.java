package com.cronexpressionparser.expression.field.datetime;


import com.cronexpressionparser.exceptions.InvalidInputException;
import com.cronexpressionparser.exceptions.RangeOutOfBoundException;
import com.cronexpressionparser.constants.AllowedSpecialCharacters;
import com.cronexpressionparser.expression.field.CronField;
import com.cronexpressionparser.utils.DateTimeValueGenerator;
import com.cronexpressionparser.utils.DateTimeValueValidator;
import com.cronexpressionparser.utils.StringUtils;


public class DateTimeField extends CronField {

    private Range range;

    public DateTimeField(String value, Range range){
        super(value);
        this.range = range;
    }

    public Range getRange(){
        return this.range;
    }

    public void validate() throws RangeOutOfBoundException, InvalidInputException {
        String value = super.getValue();
        boolean isNumeric = StringUtils.isNumeric(value);
        if(isNumeric)
            DateTimeValueValidator.validateNumber(this);
        else if(value.length() == 1)
            DateTimeValueValidator.validateCharacter(this);
        else if(value.contains(AllowedSpecialCharacters.COMMA)){
            DateTimeValueValidator.validateComma(this);
        }
        else if(value.contains(AllowedSpecialCharacters.DASH)){
            DateTimeValueValidator.validateDash(this);
        }
        else if(value.contains(AllowedSpecialCharacters.SLASH)){
            DateTimeValueValidator.validateSlash(this);
        }
    }

    @Override
    public String toString(){

        String value = super.getValue();
        if(AllowedSpecialCharacters.ASTERISK.equals(value))
            return DateTimeValueGenerator.generateAsteriskVals(this);
        else if(value.contains(AllowedSpecialCharacters.COMMA))
            return DateTimeValueGenerator.generateCommaVals(this);
        else if(value.contains(AllowedSpecialCharacters.DASH))
            return DateTimeValueGenerator.generateDashVals(this);
        else if(value.contains(AllowedSpecialCharacters.SLASH))
            return DateTimeValueGenerator.generateSlashVals(this);

        return value;
    }
}
