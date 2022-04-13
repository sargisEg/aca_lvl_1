package com.aca.homework.week13.runnable.stop;

import java.util.function.Consumer;

public class TextPrinterMain {

    public static void main(String[] args) {

        TextPrinterRunnable printerRunnable = new TextPrinterRunnable("HELLO WORLD!", s -> {
            System.out.println(s);
        });

        new Thread(printerRunnable).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printerRunnable.stop();
    }
}
