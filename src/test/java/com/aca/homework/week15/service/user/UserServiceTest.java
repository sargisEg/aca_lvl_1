package com.aca.homework.week15.service.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    public void testCreate() {
        UserService userService = new UserService(new UserRepository(new ConnectionFactory()));
        Assertions.assertEquals(
                new User("username", "name"),
                userService.create(new UserCreateParams("username", "name")));
    }
}