package com.aca.homework.week12.stopwatch;

public class StopWatch {

    private final DisplayType displayType;
    private long milliseconds;

    public StopWatch(DisplayType displayType) {
        this.displayType = displayType;
    }

    public void start() throws InterruptedException {
        while (true) {
            System.out.println(displayType.getStringRepresentationOfMilliseconds(milliseconds));
            Thread.sleep(10);
            milliseconds += 10;
        }
    }
}
