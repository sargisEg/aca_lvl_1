package com.aca.homework.week21.post.service.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CreatePostParamsTest {

    @Test
    public void testWhenLocalDateTimeIsNull() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(null, "context", "name"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenContextIsNull() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(LocalDateTime.now(), null, "name"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenCreatorNameIsNull() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(LocalDateTime.now(), "null", null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenContextIsEmpty() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(LocalDateTime.now(), "", "name"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenCreatorNameIsEmpty() {
        Assertions.assertThatThrownBy(() -> new CreatePostParams(LocalDateTime.now(), "null", ""))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}