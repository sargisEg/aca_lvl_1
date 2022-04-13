package com.aca.homework.week11.invoice;

public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(Invoice invoice) {
        super("Invoice with id: " + invoice.getId() + " not found");
    }
}