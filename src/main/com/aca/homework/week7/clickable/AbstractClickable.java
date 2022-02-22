package com.aca.homework.week7.clickable;

public abstract class AbstractClickable implements Clickable {

    private Action action;

    public AbstractClickable() {
        this.action = new Action() {
            @Override
            public void doAction(Clickable clickable) {
                System.out.println("The click method is invoked on the " + clickable.getClass().getSimpleName()
                        + " object having a name " + clickable.name());
            }
        };
    }

    @Override
    public void click() {
        action.doAction(this);
    }
}
