package com.aca.homework.week11.repository.invoice;

import java.util.Objects;

public class Invoice {

    private final String id;
    private final double amountToPay;
    private final InvoiceStatus status;

    public Invoice(String id, double amountToPay, InvoiceStatus status) {
        this.id = id;
        this.amountToPay = amountToPay;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;

        return Objects.equals(id, ((Invoice) o).id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
