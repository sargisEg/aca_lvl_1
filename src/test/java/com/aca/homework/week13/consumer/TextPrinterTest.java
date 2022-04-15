package com.aca.homework.week13.consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class TextPrinterTest {

    private TextPrinter testSubject;
    private PrinterConsumer testPrinterConsumer;

    @BeforeEach
    public void setUp() {
        testPrinterConsumer = new PrinterConsumer();
        testSubject = new TextPrinter(testPrinterConsumer);
    }

    @Test
    public void testWhenListIsEmpty() {
        testSubject.printAll(Collections.emptyList());
        Assertions.assertEquals(0, testPrinterConsumer.getMethodCount());
    }

    @Test
    public void testWhenListContains1Item() {
        testSubject.printAll(Collections.singletonList("text"));
        Assertions.assertEquals(1, testPrinterConsumer.getMethodCount());
    }

    @Test
    public void testWhenListContains2Items() {
        testSubject.printAll(List.of("Text1", "Text2"));
        Assertions.assertEquals(2, testPrinterConsumer.getMethodCount());
        Assertions.assertEquals("Text1", testPrinterConsumer.getValues().get(0));
        Assertions.assertEquals("Text2", testPrinterConsumer.getValues().get(1));
    }


}