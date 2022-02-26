package com.aca.homework.week7.button.click;

public class ButtonTest {
    public static void main(String[] args) {
        Button button = new Button(new Action() {
            @Override
            public void doAction() {
                System.out.println("clicked on the button");
            }
        });
        button.click();
    }
}
