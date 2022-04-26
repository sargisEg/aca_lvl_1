package com.aca.homework.week11.printer;

import java.util.LinkedList;
import java.util.List;

public class NumberPrinterRunnable implements Runnable {

    private final int number;

    public NumberPrinterRunnable(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        NumberPrinterRunnable.runAll(NumberPrinterRunnable.createNumberPrinterRunnables());
    }

    public static List<Runnable> createNumberPrinterRunnables() {
        List<Runnable> listOfRunnable = new LinkedList<>();

        for (int i = 1; i <= 100; i++) {
            listOfRunnable.add(new NumberPrinterRunnable(i));
        }

        return listOfRunnable;

    }

    public static void runAll(List<Runnable> runnables) {
        for (Runnable runnable : runnables) {
            runnable.run();
        }
    }

    @Override
    public void run() {
        wait100ms();
        System.out.println(number);
    }

    private void wait100ms() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start != 100) ;
    }
}
