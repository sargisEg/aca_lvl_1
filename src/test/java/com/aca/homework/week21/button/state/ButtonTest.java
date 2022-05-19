package com.aca.homework.week21.button.state;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ButtonTest {

    private Button button;

    @Test
    public void testSwitch1Time() {
        button = Button.of(new ButtonOffState());
        button.switchState();
        Assertions.assertThat(button.getButtonState().color())
                .isEqualTo(ColorType.GREEN);
        Assertions.assertThat(button.getButtonState().isEnabled())
                .isTrue();
    }

    @Test
    public void testSwitch2Time() {
        button = Button.of(new ButtonOffState());
        button.switchState();
        button.switchState();
        Assertions.assertThat(button.getButtonState().color())
                .isEqualTo(ColorType.RED);
        Assertions.assertThat(button.getButtonState().isEnabled())
                .isFalse();
    }
}