package com.aca.homework.week21.button.state;

public class ButtonOnState implements ButtonState {

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
        return new ButtonOffState();
    }
}
