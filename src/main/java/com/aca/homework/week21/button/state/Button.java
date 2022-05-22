package com.aca.homework.week21.button.state;

public class Button {

    private ButtonState buttonState;

    private Button(ButtonState buttonState) {
        this.buttonState = buttonState;
    }

    public static Button of(ButtonState buttonState) {
        return new Button(buttonState);
    }

    public void switchState() {
        this.buttonState = buttonState.nextState();
    }

    public ButtonState getButtonState() {
        return buttonState;
    }
}
