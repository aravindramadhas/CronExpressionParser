package com.cronexpressionparser.expression.field.datetime;

public class Hour extends DateTimeField {
    public Hour(String value){
        super(value, new Range(0,23));
    }
}
