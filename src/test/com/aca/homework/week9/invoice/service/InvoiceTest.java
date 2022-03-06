package com.aca.homework.week9.invoice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvoiceTest {

    @Test
    public void testToString() {
        Invoice testSubject = new Invoice("MY-ID-12",150, InvoiceType.MAN, "MY-CODE");
        Assertions.assertEquals(
                "Invoice {" +
                        " id = MY-ID-12," +
                        " amount = 150," +
                        " type = MAN," +
                        " code = MY-CODE" +
                        " }",
                testSubject.toString());
    }

}