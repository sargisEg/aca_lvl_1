package com.aca.homework.week12.temperature;

import java.io.Serializable;

public class DailyTemperature implements Serializable {

    private final int dayNumber;
    private final float degree;

    public DailyTemperature(int dayNumber, float degree) {
        this.dayNumber = dayNumber;
        this.degree = degree;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public float getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "DailyTemperature{" +
                "dayNumber=" + dayNumber +
                ", degree=" + degree +
                '}';
    }
}
