package com.aca.homework.week7.button.click;

public class Button {
    private String text;

    public void click(Action action) {
        action.doAction();
    }
}
