package com.aca.homework.week11.unique.cars;

import java.util.Scanner;

public class UserNameInput implements NameInput {

    private final Scanner scanner;

    public UserNameInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String ask() {
        return scanner.nextLine();
    }
}
