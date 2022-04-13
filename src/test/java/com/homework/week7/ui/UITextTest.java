package com.homework.week7.ui;

import com.aca.homework.week7.ui.UIText;
import com.aca.homework.week7.ui.UIView;

class UITextTest {
    public static void main(String[] args) {
        UIView textView = UIText.createTextView(10.5, 10.5, "simple text","red");
        textView.click();
    }
}