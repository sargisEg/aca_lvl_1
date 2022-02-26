package com.aca.homework.week7.clickable;

public class Image extends AbstractClickable {

    private String name;

    private Image(String name, Action action) {
        super(action);
        this.name = name;
    }

    public static Image ofName(String name, Action action) {
        return new Image(name,action);
    }

}
