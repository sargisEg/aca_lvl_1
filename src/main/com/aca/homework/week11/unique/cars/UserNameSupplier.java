package com.aca.homework.week11.unique.cars;

import java.util.Scanner;

public class UserNameSupplier implements NameSupplier {

    private final Scanner scanner;

    public UserNameSupplier() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String get() {
        return scanner.nextLine();
    }
}
