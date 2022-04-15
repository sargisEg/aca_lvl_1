package com.aca.homework.week11.repository.invoice;

import java.util.*;

public class HashSetInvoiceRepository implements InvoiceRepository {

    private final Set<Invoice> invoices;

    public HashSetInvoiceRepository() {
        this.invoices = new HashSet<>();
    }

    public int getInvoiceCount() {
        return invoices.size();
    }

    @Override
    public Invoice save(Invoice invoice) {

        if (invoice == null)
            throw new IllegalArgumentException("Added invoice cannot be null");

        boolean contains = !invoices.add(invoice);
        if (contains) {
            invoices.remove(invoice);
            invoices.add(invoice);
        }
        return invoice;
    }

    @Override
    public Invoice findById(String id) {
        for (Invoice invoice : invoices) {
            if(invoice.getId().equals(id))
                return invoice;
        }
        return null;
    }

    @Override
    public List<Invoice> findAll() {
        if(getInvoiceCount() == 0)
            return Collections.emptyList();
        return new LinkedList<>(invoices);
    }

    @Override
    public void delete(Invoice invoice) {
        if (invoice == null)
            throw new IllegalArgumentException("Invoice cannot be null");
        if(!invoices.remove(invoice)) {
            throw new InvoiceNotFoundException(invoice);
        }
    }
}
