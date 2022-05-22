package com.aca.homework.week21.button.state;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButtonOffStateTest {

    private ButtonOffState buttonOffState;

    @BeforeEach
    public void init() {
        buttonOffState = ButtonOffState.getState();
    }

    @Test
    public void testIsEnabled() {
        Assertions.assertThat(buttonOffState.isEnabled()).isFalse();
    }

    @Test
    public void testColor() {
        Assertions.assertThat(buttonOffState.color())
                .isEqualTo(ColorType.RED);
    }

    @Test
    public void testNextState() {
        Assertions.assertThat(buttonOffState.nextState())
                .isEqualTo(ButtonOnState.getState());
    }

}