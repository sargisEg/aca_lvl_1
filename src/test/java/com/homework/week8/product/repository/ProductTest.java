package com.homework.week8.product.repository;

import com.aca.homework.week8.product.repository.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Product("Test Product", 123456789);
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals("Test Product id: 123456789", testSubject.toString());
    }

    @Test
    public void equalsItselfTest() {
        Assertions.assertTrue(testSubject.equals(testSubject));
    }

    @Test
    public void equalsTest() {
        Product product = new Product("Test Product", 123456789);
        Assertions.assertTrue(testSubject.equals(product));
    }

    @Test
    public void notEqualsTest() {
        Product product = new Product("New Product", 987654321);
        Assertions.assertNotEquals(testSubject, product);
    }
}