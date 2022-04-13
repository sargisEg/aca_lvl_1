package com.homework.week13.runnable.stop;

import com.aca.homework.week13.runnable.stop.TextPrinterRunnable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextPrinterRunnableTest {

    @Test
    public void testRun() {
        final String[] test = new String[1];
        TextPrinterRunnable runnable = new TextPrinterRunnable("test", s -> {
            test[0] = s;
        });
        new Thread(runnable).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnable.stop();
        Assertions.assertEquals("test", test[0]);
    }
}