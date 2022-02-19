package com.aca.homework.week7.ui;

public class UIText extends UIView {

    private String text;

    private UIText(double width, double height, String text) {
        super(width, height);
        this.text = text;
    }

    public static UIText createTextView(double width, double height, String text) {
        return new UIText(width, height, text);
    }

    @Override
    public void click() {
        System.out.print("clicked on a text " + text);
        super.click();
    }

}
