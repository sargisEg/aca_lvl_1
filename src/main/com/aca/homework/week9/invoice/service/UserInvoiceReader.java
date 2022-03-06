package com.aca.homework.week9.invoice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInvoiceReader implements InvoiceReader{

    @Override
    public Invoice[] read() throws FileNotFoundException {
        Scanner scanner = new Scanner(
                new File("/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week9/invoice/service/invoices.txt")
        );
        scanner.nextLine();
        Invoice[] invoices = new Invoice[99];

        for (Invoice invoice : invoices) {
            String[] data = new String[4];
            data = scanner.nextLine().split(",");
            invoice = new Invoice(
                    data[0],
                    Long.valueOf(data[1]),
                    InvoiceType.SAD.name().equals(data[2]) ? InvoiceType.SAD : InvoiceType.MAN,
                    data[3]);
        }

        scanner.close();
        return invoices;
    }

}
