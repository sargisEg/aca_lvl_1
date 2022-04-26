package com.aca.homework.week11.printer;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SortedNumberPrinterRunnable implements Runnable, Comparable<SortedNumberPrinterRunnable> {

    private final int number;
    private final int time;

    public SortedNumberPrinterRunnable(int number, int time) {
        this.number = number;
        this.time = time;
    }

    public static void main(String[] args) {
        SortedNumberPrinterRunnable.runAll(createNumberPrinterRunnables());
    }

    public static Set<Runnable> createNumberPrinterRunnables() {
        Set<Runnable> setOfRunnable = new TreeSet<>();

        for (int i = 1; i <= 100; i++) {
            setOfRunnable.add(
                    new SortedNumberPrinterRunnable(i, new Random().nextInt(191) + 10)
            );
        }

        return setOfRunnable;
    }

    public static void runAll(Set<Runnable> runnables) {
        for (Runnable runnable : runnables) {
            runnable.run();
        }
    }

    @Override
    public void run() {
        waitNms(time);
        System.out.println(number);
    }

    private void waitNms(int time) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < time) ;
    }

    @Override
    public int compareTo(SortedNumberPrinterRunnable o) {
        return Integer.compare(this.time, o.time);
    }
}
