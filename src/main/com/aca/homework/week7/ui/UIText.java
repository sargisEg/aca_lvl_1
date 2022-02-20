package com.aca.homework.week7.ui;

public class UIText extends UIView {

    private String text;
    private String textColor;

    private UIText(double width, double height, String text, String textColor) {
        super(width, height);
        this.text = text;
        this.textColor = textColor;
    }

    public static UIText createTextView(double width, double height, String text, String textColor) {
        return new UIText(width, height, text, textColor);
    }

    @Override
    public void click() {
        System.out.print("clicked on a text " + text +
                " having a color "+ textColor +
                ", width: " + getWidth() +
                ", height: " + getHeight());
    }

}
