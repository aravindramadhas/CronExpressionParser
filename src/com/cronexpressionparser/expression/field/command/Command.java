package com.cronexpressionparser.expression.field.command;

import com.cronexpressionparser.expression.field.CronField;

public class Command extends CronField {

    public Command(String command){
        super(command);
    }

    @Override
    public String toString(){
        return super.getValue();
    }

}
