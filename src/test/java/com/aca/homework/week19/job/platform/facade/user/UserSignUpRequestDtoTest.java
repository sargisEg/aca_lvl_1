package com.aca.homework.week19.job.platform.facade.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserSignUpRequestDtoTest {

    @Test
    public void testWhenUsernameIsNull() {
        Assertions.assertThatThrownBy(() -> new UserSignUpRequestDto(null, "name"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> new UserSignUpRequestDto("username", null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}