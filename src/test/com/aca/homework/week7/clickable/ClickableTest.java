package com.aca.homework.week7.clickable;

import java.util.Scanner;

class ClickableTest {
    public static void main(String[] args) {

        Clickable[] clickables = new Clickable[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < clickables.length; i++) {
            System.out.println("Please type a clickable object name.");
            String name = scanner.next();
            if (name.startsWith("button"))
                clickables[i] = Button.ofName(name);
            if (name.startsWith("image"))
                clickables[i] = Image.ofName(name);
        }

        click(clickables);
    }

    public static void click(Clickable[] clickables) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a clickable name to invoke the click method");
            String name = scanner.next();
            for (int i = 0; i < clickables.length; i++) {
                if (clickables[i].name().equals(name))
                    clickables[i].click();
            }
        }
    }
}