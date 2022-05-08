package com.cronexpressionparser.expression.field.datetime;

public class MonthDay extends DateTimeField {
    public MonthDay(String value){
        super(value, new Range(1,31));
    }
}
