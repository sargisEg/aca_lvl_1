package com.aca.homework.week11.repository.invoice;

import com.aca.homework.week11.invoice.HashSetInvoiceRepository;
import com.aca.homework.week11.invoice.Invoice;
import com.aca.homework.week11.invoice.InvoiceNotFoundException;
import com.aca.homework.week11.invoice.InvoiceStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collections;
import java.util.List;

class HashSetInvoiceRepositoryTest {

    private HashSetInvoiceRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new HashSetInvoiceRepository();
    }

    @Test
    public void testSaveWhenSetIsEmpty() {
        Invoice invoice = new Invoice("myId", 125.56, InvoiceStatus.PAID);
        testSubject.save(invoice);
        Assertions.assertEquals(invoice, testSubject.findById("myId"));
    }

    @Test
    public void testSaveWhenExistsWithSameIdButNewFieldsAreDifferent() {
        Invoice invoice1 = new Invoice("myId", 125.56, InvoiceStatus.PAID);
        Invoice invoice2 = new Invoice("myId", 333.2, InvoiceStatus.UNPAID);
        testSubject.save(invoice1);
        testSubject.save(invoice2);
        Assertions.assertEquals(invoice2, testSubject.findById("myId"));
        Assertions.assertEquals(1, testSubject.getInvoiceCount());
    }

    @Test
    public void testSave2Times() {
        Invoice invoice1 = new Invoice("myId1", 125.56, InvoiceStatus.PAID);
        Invoice invoice2 = new Invoice("myId2", 333.2, InvoiceStatus.UNPAID);
        testSubject.save(invoice1);
        testSubject.save(invoice2);
        Assertions.assertEquals(2, testSubject.getInvoiceCount());
    }

    @Test
    public void testFindByIdWhenNotFound() {
        Assertions.assertNull(testSubject.findById("myId"));
    }

    @Test
    public void testFindByIdWhenFound() {
        Invoice invoice = new Invoice("myId", 125.56, InvoiceStatus.PAID);
        testSubject.save(invoice);
        Assertions.assertEquals(invoice, testSubject.findById("myId"));
    }

    @Test
    public void testFindAllWhenEmpty() {
        Assertions.assertEquals(Collections.emptyList(), testSubject.findAll());
    }

    @Test
    public void testFindAllWhenIsNotEmpty() {
        Invoice invoice1 = new Invoice("myId1", 125.56, InvoiceStatus.PAID);
        Invoice invoice2 = new Invoice("myId2", 333.2, InvoiceStatus.UNPAID);
        testSubject.save(invoice1);
        testSubject.save(invoice2);
        Assertions.assertEquals(List.of(invoice1, invoice2), testSubject.findAll());
    }

    @Test
    public void testDeleteWhenEmpty() {
        Assertions.assertThrows(InvoiceNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.delete(new Invoice("myId1", 125.56, InvoiceStatus.PAID));
            }
        });
    }

    @Test
    public void testDeleteWhenExist() {
        Invoice invoice1 = new Invoice("myId1", 125.56, InvoiceStatus.PAID);
        Invoice invoice2 = new Invoice("myId2", 333.2, InvoiceStatus.UNPAID);
        testSubject.save(invoice1);
        testSubject.save(invoice2);
        testSubject.delete(invoice1);
        Assertions.assertEquals(1, testSubject.getInvoiceCount());

    }

}