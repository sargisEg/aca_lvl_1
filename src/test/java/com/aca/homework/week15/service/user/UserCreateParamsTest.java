package com.aca.homework.week15.service.user;

import com.aca.homework.week12.params.NullFieldException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UserCreateParamsTest {

    @Test
    public void testUsernameNull() {
        Assertions.assertThrows(NullFieldException.class, () -> {
            new UserCreateParams(null, "name");
        });
    }

    @Test
    public void testNameNull() {
        Assertions.assertThrows(NullFieldException.class, () -> {
            new UserCreateParams("username", null);
        });
    }

    @Test
    public void testBothNotNull() {
        Assertions.assertDoesNotThrow(() -> {
            new UserCreateParams("u", "n");
        });
    }

}