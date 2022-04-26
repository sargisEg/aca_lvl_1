package com.aca.homework.week16.organization.create.params;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserCreateParamsTest {

    @Test
    public void testWhenFirstNameIsNull() {
        Assertions.assertThatThrownBy(() -> new UserCreateParams(null, "second"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenSecondNameIsNull() {
        Assertions.assertThatThrownBy(() -> new UserCreateParams("first", null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}