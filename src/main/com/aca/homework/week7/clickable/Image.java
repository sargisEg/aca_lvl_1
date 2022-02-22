package com.aca.homework.week7.clickable;

public class Image extends AbstractClickable {

    private String name;

    private Image(String name) {
        this.name = name;
    }

    public static Image ofName(String name) {
        return new Image(name);
    }

    @Override
    public String name() {
        return name;
    }
}
