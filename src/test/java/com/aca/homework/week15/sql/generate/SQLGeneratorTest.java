package com.aca.homework.week15.sql.generate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SQLGeneratorTest {

    @Test
    public void testGenerateInsert() {
        SQLGenerator testSubject = new SQLGenerator();
        Assertions.assertEquals(
                "insert into users (full_name, age) values ('First Second', 25)",
                testSubject.generateInsert(new User("First Second", 25))
        );
    }
}