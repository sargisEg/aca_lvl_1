package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserCreateParamsTest {

    @Test
    public void testConstructor() {
        Assertions.assertThrows(NullStringException.class, () -> {
            UserCreateParams testSubject = new UserCreateParams("user", null, "35");
        });
    }
}