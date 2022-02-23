package com.aca.homework.week7.clickable;

public abstract class AbstractClickable implements Clickable {

    private Action action;
    private String name;

    public AbstractClickable(Action action) {
        this.action = action;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public void click() {
        action.doAction(this);
    }
}
