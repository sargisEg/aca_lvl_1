package com.aca.homework.week15.service.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SQLGeneratorTest {

    @Test
    public void testGenerateSave() {
        SQLGenerator testSubject = new SQLGenerator();
        Assertions.assertEquals(
                "insert into USERS (username, name) values ('usernameValue', 'nameValue')"
                ,testSubject.generateSave(new User("usernameValue", "nameValue")));

    }
}