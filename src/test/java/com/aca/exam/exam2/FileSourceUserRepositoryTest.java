package com.aca.exam.exam2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileSourceUserRepositoryTest {

    private CrudRepository<User, String> testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = FileSourceUserRepository.getInstance();
    }

    @Test
    public void testGetInstance() {
        FileSourceUserRepository testUserRepository = FileSourceUserRepository.getInstance();
        Assertions.assertTrue(testUserRepository == testSubject);
    }

    @Test
    public void testFindByIdWhenIdIsNotFound() {
        Assertions.assertNull(testSubject.findById("myId"));
    }

    @Test
    public void testFindByIdWhenIdIsFound() {
        User testUser = new User("barracudaassign", "Kaiya", "Dunlap");
        Assertions.assertEquals(testUser, testSubject.findById("barracudaassign"));
    }

    @Test
    public void testFindAll() {
        List<User> myList = List.of(
                new User("dairyfootball", "Ally", "Baca"),
                new User("impossibleimmediate", "Kara", "Ayaan"),
                new User("blessingforeign", "Dalton", "Russell"),
                new User("burberryspectral", "Parsa", "Miller"),
                new User("lardbear", "Carolina", "Lara"),
                new User("shawlinspire", "Janea", "Dawson"),
                new User("meantfirethorn", "Alexa", "Grohs"),
                new User("barracudaassign", "Kaiya", "Dunlap")
        );
        Assertions.assertEquals(myList, testSubject.findAll());
    }

}