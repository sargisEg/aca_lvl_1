package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserUpdateParamsTest {

    @Test
    public void testConstructor() {
        UserUpdateParams testSubject = new UserUpdateParams("user", "Jon", "35");
        Assertions.assertNotNull(testSubject.getAge());
        Assertions.assertNotNull(testSubject.getUsername());
        Assertions.assertNotNull(testSubject.getFirstName());
    }
}