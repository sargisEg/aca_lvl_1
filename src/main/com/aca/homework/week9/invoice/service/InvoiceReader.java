package com.aca.homework.week9.invoice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface InvoiceReader {

    Invoice[] read() throws FileNotFoundException;

}
