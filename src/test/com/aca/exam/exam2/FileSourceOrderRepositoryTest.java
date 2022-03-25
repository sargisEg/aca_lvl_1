package com.aca.exam.exam2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileSourceOrderRepositoryTest {

    private FileSourceOrderRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new FileSourceOrderRepository(FileSourceUserRepository.getInstance());
    }

    @Test
    public void testFindByIdWhenIdIsNotFound() {
        Assertions.assertNull(testSubject.findById(25));
    }

    @Test
    public void testFindByIdWhenIdIsFound() {
        User testUser = new User("shawlinspire", "Janea", "Dawson");
        Order testOrder = new Order(9, "picnic mat", 3000, testUser);
        Assertions.assertEquals(testOrder, testSubject.findById(9));
    }

    @Test
    public void testFindAllSize() {
        Assertions.assertEquals(9, testSubject.findAll().size());
    }

    @Test
    public void testFindAllByUserId() {
        User testUser = new User("shawlinspire", "Janea", "Dawson");
        List<Order> testOrders = List.of(
                new Order(2, "kafka book", 25000, testUser),
                new Order(5, "michael kors watch", 23000, testUser),
                new Order(9, "picnic mat", 3000, testUser)
        );
        Assertions.assertEquals(testOrders, testSubject.findAllByUserId("shawlinspire"));
    }
}