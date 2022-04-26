package com.aca.homework.week15.service.user;

import org.junit.jupiter.api.Test;

class UserRepositoryTest {

    @Test
    public void testSave() {
        UserRepository testSubject = new UserRepository(new ConnectionFactory());
        testSubject.save(new User("username1", "name1"));
    }
}