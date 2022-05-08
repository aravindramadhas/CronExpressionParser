package com.cronexpressionparser.parser;

import com.cronexpressionparser.expression.CronExpression;
import com.cronexpressionparser.expression.field.command.Command;
import com.cronexpressionparser.expression.field.datetime.*;

public class CronStringParser {

    public CronExpression parse(String input){

        CronExpression expression = new CronExpression();
        String split[] = input.split(" ");
        if(split.length != 6)
            throw new RuntimeException("Number of arguments is incorrect");

        expression.setMinute(new Minute(split[0]));
        expression.setHour(new Hour(split[1]));
        expression.setMonthDay(new MonthDay(split[2]));
        expression.setMonth(new Month(split[3]));
        expression.setWeekDay(new WeekDay(split[4]));
        expression.setCommand(new Command(split[5]));

        return expression;

    }
}
