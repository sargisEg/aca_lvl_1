package com.aca.homework.week8.product.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class NotImplementedProductRepositoryTest {

    private ProductRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new NotImplementedProductRepository();
    }

    @Test
    public void saveTest() {
        Product product = new Product("Test Product", 111222333L);
        Assertions.assertThrows(NotImplementedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(product);
            }
        });
    }

    @Test
    public void getByIdTest() {
        Assertions.assertThrows(NotImplementedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.getById(111222333L);
            }
        });
    }

    @Test
    public void findByIdTest() {
        Assertions.assertThrows(NotImplementedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.findById(111222333L);
            }
        });
    }
}