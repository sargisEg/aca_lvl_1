package com.homework.week10.user.repository;

import com.aca.homework.week10.user.repository.CrudRepository;
import com.aca.homework.week10.user.repository.User;
import com.aca.homework.week10.user.repository.UserNotFoundException;
import com.aca.homework.week10.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private CrudRepository testSubject;


    @BeforeEach
    public void setUp() {
        testSubject = new UserRepository();
    }

    @Test
    public void testSaveWhenUserIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(null);
            }
        });
    }

    @Test
    public void testSaveWhenUserDoesNotExist() {
        User testUser = new User(123456789L, "username", 25);
        testSubject.save(testUser);
        Assertions.assertEquals(testUser, testSubject.findById(123456789L));
        Assertions.assertEquals(1, testSubject.count());
    }

    @Test
    public void testSaveWhenUserExist() {
        User testUser = new User(123456789L, "username", 25);
        testSubject.save(testUser);
        testSubject.save(testUser);
        Assertions.assertEquals(testUser, testSubject.findById(123456789L));
        Assertions.assertEquals(1, testSubject.count());
    }

    @Test
    public void testDeleteWhenEntityNotFound() {
        User testUser = new User(123456789L, "username", 25);
        Assertions.assertThrows(UserNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.delete(testUser);
            }
        });
    }

    @Test
    public void testDelete() {
        User testUser = new User(123456789L, "username", 25);
        testSubject.save(testUser);
        testSubject.delete(testUser);
        Assertions.assertEquals(0, testSubject.count());
    }

    @Test
    public void testFindByIdWhenDoesNotFound() {
        Assertions.assertEquals(null, testSubject.findById(123456789L));
    }

    @Test
    public void testCountWhenRepositoryIsEmpty() {
        Assertions.assertEquals(0, testSubject.count());
    }

    @Test
    public void testCountWhenRepositoryContains2Entities() {
        testSubject.save(new User(123456789L, "username", 25));
        testSubject.save(new User(987654321L, "username", 25));
        Assertions.assertEquals(2, testSubject.count());
    }

    @Test
    public void testDeleteAllWhenIsEmpty() {
        testSubject.deleteAll();
        Assertions.assertEquals(0, testSubject.count());
    }

    @Test
    public void testDeleteAllWhenContains2Entities() {
        testSubject.save(new User(123456789L, "username", 25));
        testSubject.save(new User(987654321L, "username", 25));
        testSubject.deleteAll();
        Assertions.assertEquals(0, testSubject.count());
    }

    @Test
    public void testFindAllWhenEmpty() {
        Assertions.assertEquals(0, testSubject.findAll().size());
    }

    @Test
    public void testFindAllWhenContains3Entities() {
        User user1 = new User(123456789L, "username1", 25);
        User user2 = new User(987654321L, "username2", 26);
        User user3 = new User(123789456L, "username3", 27);

        testSubject.save(user1);
        testSubject.save(user2);
        testSubject.save(user3);

        Assertions.assertEquals(user1, testSubject.findAll().get(0));
        Assertions.assertEquals(user2, testSubject.findAll().get(1));
        Assertions.assertEquals(user3, testSubject.findAll().get(2));
    }


}