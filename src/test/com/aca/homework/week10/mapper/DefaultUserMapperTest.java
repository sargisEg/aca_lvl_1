package com.aca.homework.week10.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultUserMapperTest {

    @Test
    public void testMap() {
        UserMapper mapper = new DefaultUserMapper();
        User testUser = new User(1L, "student", "Lord");
        UserModel mapUser = mapper.map(testUser);
        Assertions.assertEquals("student", mapUser.getUsername());
        Assertions.assertEquals("Lord", mapUser.getFirstName());
    }
}