package com.cronexpressionparser;

import com.cronexpressionparser.exceptions.InvalidInputException;
import com.cronexpressionparser.exceptions.RangeOutOfBoundException;
import com.cronexpressionparser.expression.CronExpression;
import com.cronexpressionparser.parser.CronStringParser;

public class Main {

    public static void main(String[] args) throws InvalidInputException, RangeOutOfBoundException {
        String input  = args[0];
        CronStringParser parser = new CronStringParser();
        CronExpression cronExp = parser.parse(input);
        cronExp.validate();
        cronExp.print();
    }
}
