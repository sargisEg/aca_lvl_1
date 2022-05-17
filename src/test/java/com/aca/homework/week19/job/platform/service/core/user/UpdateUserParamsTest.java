package com.aca.homework.week19.job.platform.service.core.user;

import com.aca.homework.week19.job.platform.service.core.user.UpdateUserParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateUserParamsTest {

    @Test
    public void testWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> new UpdateUserParams(null, "username", "name", false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenUsernameIsNull() {
        Assertions.assertThatThrownBy(() -> new UpdateUserParams(1L, null, "name", false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> new UpdateUserParams(1L, "username", null, false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenUsernameIsEmpty() {
        Assertions.assertThatThrownBy(() -> new UpdateUserParams(1L,"", "name", false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenNameIsEmpty() {
        Assertions.assertThatThrownBy(() -> new UpdateUserParams(1L, "username", "", false))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}