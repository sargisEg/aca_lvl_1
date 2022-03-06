package com.aca.homework.week9.invoice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class InvoiceServiceTest {

    @Test
    public void testTotalAmountByTypeSAD() {
        InvoiceService testSubject = new InvoiceService(new InvoiceReader() {
            @Override
            public Invoice[] read() throws FileNotFoundException {

                Invoice[] testInvoices = {
                        new Invoice("testID10", 100, InvoiceType.SAD, "MY-CODE10"),
                        new Invoice("testID11", 110, InvoiceType.MAN, "MY-CODE11"),
                        new Invoice("testID12", 120, InvoiceType.MAN, "MY-CODE12"),
                        new Invoice("testID13", 130, InvoiceType.SAD, "MY-CODE13"),
                        new Invoice("testID14", 140, InvoiceType.SAD, "MY-CODE14")
                };
                return testInvoices;
            }
        });

        testSubject.load();

        Assertions.assertEquals(370, testSubject.totalAmountByType(InvoiceType.SAD));
    }

    @Test
    public void testGetBySADType() {
        InvoiceService testSubject = new InvoiceService(new InvoiceReader() {
            @Override
            public Invoice[] read() throws FileNotFoundException {

                Invoice[] testInvoices = {
                        new Invoice("testID10", 100, InvoiceType.SAD, "MY-CODE10"),
                        new Invoice("testID11", 110, InvoiceType.MAN, "MY-CODE11"),
                        new Invoice("testID12", 120, InvoiceType.MAN, "MY-CODE12"),
                        new Invoice("testID13", 130, InvoiceType.SAD, "MY-CODE13")
                };
                return testInvoices;
            }
        });

        testSubject.load();

        Invoice[] result = testSubject.getByType(InvoiceType.SAD);
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(new Invoice("testID10", 100, InvoiceType.SAD, "MY-CODE10"), result[0]);
        Assertions.assertEquals(new Invoice("testID13", 130, InvoiceType.SAD, "MY-CODE13"), result[1]);

    }

    @Test
    public void testGetByMANType() {
        InvoiceService testSubject = new InvoiceService(new InvoiceReader() {
            @Override
            public Invoice[] read() throws FileNotFoundException {

                Invoice[] testInvoices = {
                        new Invoice("testID10", 100, InvoiceType.SAD, "MY-CODE10"),
                        new Invoice("testID11", 110, InvoiceType.MAN, "MY-CODE11"),
                        new Invoice("testID12", 120, InvoiceType.MAN, "MY-CODE12"),
                        new Invoice("testID13", 130, InvoiceType.SAD, "MY-CODE13")
                };
                return testInvoices;
            }
        });
        testSubject.load();

        Invoice[] result = testSubject.getByType(InvoiceType.MAN);
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(new Invoice("testID11", 110, InvoiceType.MAN, "MY-CODE11"), result[0]);
        Assertions.assertEquals(new Invoice("testID12", 120, InvoiceType.MAN, "MY-CODE12"), result[1]);
    }

    @Test
    public void getBySADTypeAndCode() {
        InvoiceService testSubject = new InvoiceService(new InvoiceReader() {
            @Override
            public Invoice[] read() throws FileNotFoundException {

                Invoice[] testInvoices = {
                        new Invoice("testID10", 100, InvoiceType.SAD, "MY-CODE10"),
                        new Invoice("testID11", 110, InvoiceType.MAN, "MY-CODE11"),
                        new Invoice("testID12", 120, InvoiceType.MAN, "MY-CODE12"),
                        new Invoice("testID13", 130, InvoiceType.SAD, "MY-CODE13")
                };
                return testInvoices;
            }
        });

        testSubject.load();

        Invoice[] result = testSubject.getByTypeAndCode(InvoiceType.SAD, "MY-CODE10");
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(new Invoice("testID10", 100, InvoiceType.SAD, "MY-CODE10"), result[0]);
    }
}