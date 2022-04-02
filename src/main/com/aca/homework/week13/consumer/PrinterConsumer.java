package com.aca.homework.week13.consumer;

import java.util.function.Consumer;

public class PrinterConsumer implements Consumer<String> {

    private int methodCount;

    public int getMethodCount() {
        return methodCount;
    }

    @Override
    public void accept(String s) {
        methodCount++;
        System.out.println(s);
    }
}
