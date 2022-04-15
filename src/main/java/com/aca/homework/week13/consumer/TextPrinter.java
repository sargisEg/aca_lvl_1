package com.aca.homework.week13.consumer;

import java.util.List;

public class TextPrinter {

    private final PrinterConsumer consumer;

    public TextPrinter(PrinterConsumer consumer) {
        this.consumer = consumer;
    }

    public void printAll(List<String> list) {
        list.forEach(consumer);
    }
}
