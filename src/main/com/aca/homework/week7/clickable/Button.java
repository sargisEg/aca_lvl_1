package com.aca.homework.week7.clickable;

public class Button extends AbstractClickable {

    private String name;

    private Button(String name) {
        this.name = name;
    }

    public static Button ofName(String name) {
        return new Button(name);
    }

    @Override
    public String name() {
        return name;
    }
}
