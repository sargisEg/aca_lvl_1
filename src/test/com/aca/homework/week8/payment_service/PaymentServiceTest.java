package com.aca.homework.week8.payment_service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private PaymentService testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new PaymentService();
    }

    @Test
    public void testServiceAnnotation() {
        Assertions.assertEquals(true, testSubject.getClass().getDeclaredAnnotations()[0].annotationType() == Service.class);
    }

    @Test
    public void testPaymentAmount() {
        Assertions.assertEquals(100, testSubject.pay(100).getPayAmount());
    }

    @Test
    public void testDuration() {
        Assertions.assertTrue(testSubject.pay(100).getProcessingTime() > 200
                && testSubject.pay(100).getProcessingTime() < 800);
    }
}