package com.aca.homework.week21.button.state;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButtonOnStateTest {

    private ButtonOnState buttonOnState;

    @BeforeEach
    public void init() {
        buttonOnState = ButtonOnState.getState();
    }

    @Test
    public void testIsEnabled() {
        Assertions.assertThat(buttonOnState.isEnabled()).isTrue();
    }

    @Test
    public void testColor() {
        Assertions.assertThat(buttonOnState.color())
                .isEqualTo(ColorType.GREEN);
    }

    @Test
    public void testNextState() {
        Assertions.assertThat(buttonOnState.nextState())
                .isEqualTo(ButtonOffState.getState());
    }

}