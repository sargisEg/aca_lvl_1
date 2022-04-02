package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserUpdateParamsTest {

    @Test
    public void testConstructor() {
        Assertions.assertThrows(NullStringException.class, () -> {
            UserUpdateParams testSubject = new UserUpdateParams("user", null, "35");
        });
    }
}