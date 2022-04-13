package com.aca.homework.week13.consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class PrinterConsumer implements Consumer<String> {

    private int methodCount;
    private final List<String> values = new LinkedList<>();

    public int getMethodCount() {
        return methodCount;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public void accept(String s) {
        methodCount++;
        values.add(s);
        System.out.println(s);
    }
}
