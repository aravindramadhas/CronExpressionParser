package com.cronexpressionparser.expression;

import com.cronexpressionparser.exceptions.InvalidInputException;
import com.cronexpressionparser.exceptions.RangeOutOfBoundException;
import com.cronexpressionparser.expression.field.command.Command;
import com.cronexpressionparser.expression.field.datetime.*;
import com.cronexpressionparser.utils.StringUtils;

public class CronExpression {

    private Minute minute;
    private Hour hour;
    private MonthDay monthDay;
    private Month month;
    private WeekDay weekDay;
    private Command command;

    public Minute getMinute() {
        return minute;
    }

    public void setMinute(Minute minute) {
        this.minute = minute;
    }

    public Hour getHour() {
        return hour;
    }

    public void setHour(Hour hour) {
        this.hour = hour;
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void validate() throws InvalidInputException, RangeOutOfBoundException {

        minute.validate();
        hour.validate();
        monthDay.validate();
        month.validate();
        weekDay.validate();

    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + StringUtils.appendLabel("minute"));
        sb.append(minute.toString());
        sb.append("\n" + StringUtils.appendLabel("hour"));
        sb.append(hour.toString());
        sb.append("\n" + StringUtils.appendLabel("day of month"));
        sb.append(monthDay.toString());
        sb.append("\n" + StringUtils.appendLabel("month"));
        sb.append(month.toString());
        sb.append("\n" + StringUtils.appendLabel("day of week"));
        sb.append(weekDay.toString());
        sb.append("\n" + StringUtils.appendLabel("command"));
        sb.append(command.toString());
        sb.append("\n");

        System.out.print(sb.toString());
    }
}
