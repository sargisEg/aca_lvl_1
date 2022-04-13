package com.homework.week10.mapper;

import com.aca.homework.week10.mapper.DefaultUserMapper;
import com.aca.homework.week10.mapper.User;
import com.aca.homework.week10.mapper.UserMapper;
import com.aca.homework.week10.mapper.UserModel;
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