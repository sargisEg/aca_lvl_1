package com.aca.homework.week7.ui;

public abstract class UIView {
    private double width;
    private double height;

    public UIView(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void click() {
        System.out.println(" width: " + width + ", height: " + height);
    }
}
