package com.aca.homework.week8.random_generator;

public class Result {
    private String text;
    private long duration;

    private Result(String text, long duration) {
        this.text = text;
        this.duration = duration;
    }

    public static Result of(String text, long duration) {
        return new Result(text, duration);
    }

    public String getText() {
        return text;
    }

    public long getDuration() {
        return duration;
    }
}
