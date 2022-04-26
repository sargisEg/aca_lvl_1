package com.aca.homework.week14.objectmapper;

import java.util.Arrays;

public class CommitsPerWeek {

    private int total;
    private long week;
    private int[] days;

    public int getTotal() {
        return total;
    }

    public long getWeek() {
        return week;
    }

    public int[] getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "CommitsPerWeek{" +
                "total=" + total +
                ", week=" + week +
                ", days=" + Arrays.toString(days) +
                '}';
    }
}
