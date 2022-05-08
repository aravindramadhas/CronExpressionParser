#Cron Expression Parser

The Cron Expression Parser takes a cron expression as an argument and expands each field to show the time at which  it will run.

The parser takes a standard cron format with five time fields(minute, hour, day of month, month and day of week) and a command.

##CRON Expression

A CRON expression is a string representing the schedule for a particular command to execute. The fields of a CRON expression are as follows:

```
*    *    *    *    *    
|    |    |    |    |         
|    |    |    |    |
|    |    |    |    +----- day of week (1 - 7) (Sunday = 1)
|    |    |    +---------- month (1 - 12)
|    |    +--------------- day of month (1 - 31)
|    +-------------------- hour (0 - 23)
+------------------------- minute (0 - 59)
```


The field names, their allowed values and their allowed special characters are given below

| Field Name   | Allowed Values | Allowed Special Characters |
|--------------|----------------|----------------------------|
| Minute       | 0-59           |      , - * /                      |
| Hour         | 0-23           |        , - * /                    |
| Day of Month | 1-31           |         , - * /                   |
| Month        | 1-12           |         , - * /                   |
| Day of Week  | 1-7            |         , - * /                   |



##Allowed Special Characters

In this system, the following special characters are allowed

| Operator        | Purpose                                   | Example                                                                                                                                                        |
|-----------------|-------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| asterisk( * )   | Specifies all possible values for a field | An asterisk in the hour time field is equivalent to “every hour.”                                                                                              |
| dash ( - )      | Specifies a range of values               | 2-5, which is equivalent to 2,3,4,5                                                                                                                            |
| comma ( , )     | Specifies a list of values                | 1,3,4,7,8                                                                                                                                                      |
| slash ( / )     | Used to skip a given number of values     | */3 in the hour time field is equivalent to 0,3,6,9,12,15,18,21. The asterisk ( * ) specifies “every hour,” but the 1/3 means only the first, fourth, seventh. |


##Running the project

The application takes a single argument as shown below

```
java com/cronexpressionparser/Main "*/15 0 1,15 * 2-5 /usr/bin/find"
```
Running the above cron expression gives the below output

```
minute        0 15 30 45 
hour          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 
day of month  1 15 
month         1 2 3 4 5 6 7 8 9 10 11 12 
day of week   2 3 4 5 
command       /usr/bin/find
```

The output is formatted with the field name taking the first 14 columns and the times as the space separated list following it.


