package com.aca.homework.week7.ui;

public class UIButton extends UIView {

    private String buttonColor;

    private UIButton(double width, double height, String buttonColor) {
        super(width, height);
        this.buttonColor = buttonColor;
    }

    public static UIButton createButton(double width, double height, String buttonColor) {
        return new UIButton(width, height, buttonColor);
    }

    @Override
    public void click() {
        System.out.print("clicked on a button having a color " + buttonColor +
                ", width: " + getWidth() +
                ", height: " + getHeight());
    }
}
