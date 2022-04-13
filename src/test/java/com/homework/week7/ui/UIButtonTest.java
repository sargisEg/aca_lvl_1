package com.homework.week7.ui;

import com.aca.homework.week7.ui.UIButton;
import com.aca.homework.week7.ui.UIView;

class UIButtonTest {
    public static void main(String[] args) {
        UIView button = UIButton.createButton(5, 5, "green");
        button.click();
    }
}