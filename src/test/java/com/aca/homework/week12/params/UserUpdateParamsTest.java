package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserUpdateParamsTest {

    @Test
    public void testConstructorFirstNameNull() {
        Assertions.assertThrows(NullFieldException.class, () -> {
            UserUpdateParams testSubject = new UserUpdateParams("user", null, 35);
        });
    }

    @Test
    public void testConstructorUsernameNull() {
        Assertions.assertThrows(NullFieldException.class, () -> {
            UserUpdateParams testSubject = new UserUpdateParams(null, "name", 35);
        });
    }
    @Test
    public void testConstructorAgeNull() {
        Assertions.assertThrows(NullFieldException.class, () -> {
            UserUpdateParams testSubject = new UserUpdateParams("user", "name", null);
        });
    }
}