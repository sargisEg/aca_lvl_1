package com.aca.homework.week21.button.state;

public class ButtonOffState implements ButtonState {

    private static ButtonOffState buttonOffState = null;

    private ButtonOffState() {
    }

    public static ButtonOffState getState() {
        if (buttonOffState == null) {
            buttonOffState = new ButtonOffState();
        }
        return buttonOffState;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public ColorType color() {
        return ColorType.RED;
    }

    @Override
    public ButtonState nextState() {
        return ButtonOnState.getState();
    }

}
