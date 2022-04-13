package com.homework.week7.button.click;

import com.aca.homework.week7.button.click.Action;
import com.aca.homework.week7.button.click.Button;

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
