package com.aca.homework.week13.runnable.stop;

import java.util.function.Consumer;

public class TextPrinterRunnable implements Runnable {

    private final Consumer<String> consumer;
    private final String name;
    private boolean isRunning = true;

    public TextPrinterRunnable(String name, Consumer<String> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (isRunning) {

            consumer.accept(name);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isRunning = false;
    }
}
