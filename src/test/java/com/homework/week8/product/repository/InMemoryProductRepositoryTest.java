package com.homework.week8.product.repository;

import com.aca.homework.week8.product.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class InMemoryProductRepositoryTest {

    private ProductRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new InMemoryProductRepository();
    }

    @Test
    public void testSaveWhenProductIsNull() {
        RuntimeException exception = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(null);
            }
        });
        Assertions.assertEquals("Product is null", exception.getMessage());
    }

    @Test
    public void testSaveWhenProductDoesNotExist() {
        Product product = new Product("Test Product", 111222333444L);
        Assertions.assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(product);
            }
        });
    }

    @Test
    public void testSaveWhenProductAlreadyExist() {
        Product product = new Product("Test Product", 111222333444L);
        testSubject.save(product);
        Assertions.assertThrows(ProductAlreadyExistsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(product);
            }
        });
    }

    @Test
    public void testFindByIdWhenProductDoesNotExist() {
        Assertions.assertNull(testSubject.findById(123456789L));
    }

    @Test
    public void testFindByIdWhenProductExists() {
        Product product = new Product("Test Product", 111222333444L);
        testSubject.save(product);
        Assertions.assertEquals(product, testSubject.findById(111222333444L));
    }

    @Test
    public void testGetByIdWhenProductDoesNotExist() {
        RuntimeException exception = Assertions.assertThrows(ProductNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.getById(111222333444L);
            }
        });
        Assertions.assertEquals("Product by 111222333444 id not exist.", exception.getMessage());
    }

    @Test
    public void testGetByIdWhenProductExists() {
        Product product = new Product("Test Product", 111222333444L);
        testSubject.save(product);
        Assertions.assertEquals(product, testSubject.getById(111222333444L));
    }
}