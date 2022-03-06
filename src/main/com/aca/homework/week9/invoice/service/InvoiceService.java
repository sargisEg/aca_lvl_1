package com.aca.homework.week9.invoice.service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class InvoiceService {

    private Invoice[] invoices;
    private InvoiceReader reader;

    public InvoiceService(InvoiceReader reader) {
        this.reader = reader;
    }

    public void load() {
        try {
            invoices = reader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public long totalAmountByType(InvoiceType type) {
        long sum = 0;
        for (Invoice invoice : invoices) {
            if (invoice.getType().equals(type)) {
                sum += invoice.getAmount();
            }
        }
        return sum;
    }

    public Invoice[] getByType(InvoiceType type) {
        Invoice[] invoices = new Invoice[99];

        int j = 0;
        for (int i = 0; i < this.invoices.length; i++) {
            if (this.invoices[i].getType().equals(type)) {
                invoices[j] = this.invoices[i];
                j++;
            }
        }
        Invoice[] currentTypeInvoices = new Invoice[j];
        for (int i = 0; i < j; i++) {
            currentTypeInvoices[i] = invoices[i];
        }
        return currentTypeInvoices;
    }

    public Invoice[] getByTypeAndCode(InvoiceType type, String code) {

        Invoice[] invoices = new Invoice[99];

        int j = 0;
        for (int i = 0; i < this.invoices.length; i++) {
            if (this.invoices[i].getType().equals(type)
                    && this.invoices[i].getCode().equals(code)) {
                invoices[j] = this.invoices[i];
                j++;
            }
        }

        Invoice[] currentTypeAndCodeInvoices = new Invoice[j];

        for (int i = 0; i < j; i++) {
            currentTypeAndCodeInvoices[i] = this.invoices[i];
        }
        return currentTypeAndCodeInvoices;
    }
}
