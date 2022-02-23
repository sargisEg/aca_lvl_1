package com.aca.homework.week7.clickable;

public class Button extends AbstractClickable {

    private String name;

    private Button(String name) {
        super(new Action() {
            @Override
            public void doAction(Clickable clickable) {
                System.out.println("The click method is invoked on the " + clickable.getClass().getSimpleName()
                        + " object having a name " + clickable.name());
            }
        });
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
