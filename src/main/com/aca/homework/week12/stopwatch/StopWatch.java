package com.aca.homework.week12.stopwatch;

public class StopWatch {

    private final DisplayType displayType;
    private long milliseconds;

    public StopWatch(DisplayType displayType) {
        this.displayType = displayType;
    }

    public void start() {
        while (true) {
            System.out.println(displayType.getStringRepresentationOfMilliseconds(milliseconds));
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10);
            milliseconds += 10;
        }
    }
}
