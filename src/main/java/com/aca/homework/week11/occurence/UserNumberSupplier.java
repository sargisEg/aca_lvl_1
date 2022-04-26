package com.aca.homework.week11.occurence;

import java.util.Scanner;

public class UserNumberSupplier implements NumberSupplier {

    @Override
    public String getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
