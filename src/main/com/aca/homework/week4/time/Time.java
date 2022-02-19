package com.aca.homework.week4.time;

public class Time {

    private long timeInSec;

    public static void main(String[] args) {
        Time time = new Time(0);
        System.out.println(time.getHours());
        System.out.println(time.getMinutes());
        System.out.println(time.getSeconds());

        Time time1 = new Time(3600*25+52*60+52);
        System.out.println(time1.getHours());
        System.out.println(time1.getMinutes());
        System.out.println(time1.getSeconds());
    }

    public Time(long time){
        timeInSec = time;
    }

    public long getHours(){
        return timeInSec/3600;
    }
    public long getMinutes(){
        return (timeInSec-(getHours()*3600))/60;
    }

    public long getSeconds(){
        return (timeInSec - (getHours()*3600) - (getMinutes()*60));
    }
}


/*Create a Time method that takes seconds of a day in a constructor
(starting from 00:00:00) and provides 3 method to get hours, minutes and seconds of the time.

Time time = new Time(0)
time.getSeconds() -> should return 0
time.getMinutes() -> should return 0
time.getHours() -> should return 0

Time time = new Time(3600+5*60+6)
time.getSeconds() -> should return 6
time.getMinutes() -> should return 5
time.getHours() -> should return 1
print the result of each method invocation*/
