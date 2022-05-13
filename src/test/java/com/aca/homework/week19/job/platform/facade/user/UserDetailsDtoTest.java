package com.aca.homework.week19.job.platform.facade.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDetailsDtoTest {

    @Test
    public void testWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> {
            new UserDetailsDto(null, "username", "name", false);
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenUsernameIsNull() {
        Assertions.assertThatThrownBy(() -> {
            new UserDetailsDto(12L, null, "name", false);
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> {
            new UserDetailsDto(12L, "username", null, false);
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenErrorsIsNull() {
        Assertions.assertThatThrownBy(() -> {
            new UserDetailsDto(null);
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }

}