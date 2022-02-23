package com.aca.homework.week7.clickable;

public class Image extends AbstractClickable {

    private String name;

    private Image(String name) {
        super(new Action() {
            @Override
            public void doAction(Clickable clickable) {
                System.out.println("The click method is invoked on the " + clickable.getClass().getSimpleName()
                        + " object having a name " + clickable.name());
            }
        });
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
