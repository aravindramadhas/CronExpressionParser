package com.cronexpressionparser.expression.field.datetime;

import com.cronexpressionparser.expression.field.datetime.DateTimeField;
import com.cronexpressionparser.expression.field.datetime.Range;

public class WeekDay extends DateTimeField {
    public WeekDay(String value){
        super(value, new Range(1,7));
    }
}
