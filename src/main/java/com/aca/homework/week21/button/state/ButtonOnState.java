package com.aca.homework.week21.button.state;

public class ButtonOnState implements ButtonState {

    private static ButtonOnState buttonOnState = null;

    private ButtonOnState() {
    }

    public static ButtonOnState getState() {
        if (buttonOnState == null) {
            buttonOnState = new ButtonOnState();
        }
        return buttonOnState;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public ColorType color() {
        return ColorType.GREEN;
    }

    @Override
    public ButtonState nextState() {
        return ButtonOffState.getState();
    }
}
