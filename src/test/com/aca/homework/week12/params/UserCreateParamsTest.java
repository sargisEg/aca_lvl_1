package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserCreateParamsTest {

    @Test
    public void testConstructorFirstNameNull() {
        Assertions.assertThrows(NullStringException.class, () -> {
            UserCreateParams testSubject = new UserCreateParams("user", null, "35");
        });
    }

    @Test
    public void testConstructorUsernameNull() {
        Assertions.assertThrows(NullStringException.class, () -> {
            UserCreateParams testSubject = new UserCreateParams(null, "name", "35");
        });
    }
    @Test
    public void testConstructorAgeNull() {
        Assertions.assertThrows(NullStringException.class, () -> {
            UserCreateParams testSubject = new UserCreateParams("user", "name", null);
        });
    }
}