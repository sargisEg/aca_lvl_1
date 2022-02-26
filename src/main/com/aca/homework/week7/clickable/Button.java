package com.aca.homework.week7.clickable;

public class Button extends AbstractClickable {

    private String name;

    private Button(String name, Action action) {
        super(action);
        this.name = name;
    }

    public static Button ofName(String name, Action action) {
        return new Button(name, action);
    }

}
