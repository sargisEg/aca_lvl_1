package com.aca.homework.week7.button.click;

public class Button {
    private String text;
    private Action action;

    public Button(Action action) {
        this.action = action;
    }

    public void click() {
        action.doAction();
    }
}
