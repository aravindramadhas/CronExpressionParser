package com.cronexpressionparser.expression.field.datetime;

public class Range {

    private int fromValue;
    private int toValue;

    public Range(int fromValue, int toValue){
        this.fromValue = fromValue;
        this.toValue = toValue;
    }

    public boolean encloses(int value){
        if(value >= this.fromValue && value <=this.toValue){
            return  true;
        }
        return false;
    }

    public int getFromValue() {
        return fromValue;
    }

    public int getToValue() {
        return toValue;
    }

    @Override
    public String toString(){
        return this.fromValue + "-" + this.toValue;
    }

}
