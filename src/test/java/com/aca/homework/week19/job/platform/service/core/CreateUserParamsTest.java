package com.aca.homework.week19.job.platform.service.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateUserParamsTest {

    @Test
    public void testWhenUsernameIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams(null, "name", false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("username", null, false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenUsernameIsEmpty() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("", "name", false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenNameIsEmpty() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("username", "", false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}