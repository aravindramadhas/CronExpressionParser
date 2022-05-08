package com.cronexpressionparser.expression.field.datetime;

public class Minute extends DateTimeField {
    public Minute(String value){
        super(value, new Range(0,59));
    }
}
