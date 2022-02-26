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
        int testArgument = 100;
        Assertions.assertEquals(100, testSubject.pay(testArgument).getPayAmount());
    }

    @Test
    public void testDuration() {
        int testArgument = 100;
        Assertions.assertTrue(testSubject.pay(testArgument).getProcessingTime() > 200
                && testSubject.pay(testArgument).getProcessingTime() < 800);
    }
}