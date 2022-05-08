package com.cronexpressionparser.expression.field.datetime;

public class Month extends DateTimeField {
    public Month(String value){
        super(value, new Range(1,12));
    }
}
