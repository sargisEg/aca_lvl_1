package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserCreateParamsTest {

    @Test
    public void testConstructor() {
        UserCreateParams testSubject = new UserCreateParams("user", "Jon", "35");
        Assertions.assertNotNull(testSubject.getAge());
        Assertions.assertNotNull(testSubject.getUsername());
        Assertions.assertNotNull(testSubject.getFirstName());
    }
}