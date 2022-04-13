package com.homework.week8.credit_card;

import com.aca.homework.week8.credit_card.CreditCard;
import com.aca.homework.week8.credit_card.InsufficientBalanceException;
import com.aca.homework.week8.credit_card.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private PaymentService testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new PaymentService();
    }

    @Test
    public void testWhenBalanceNotEnough() {
        CreditCard card = new CreditCard("1111 2222 3333 4444", 100);
        RuntimeException exception = Assertions.assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.pay(card, 150);
            }
        });
        Assertions.assertEquals("Not enough money in card. Amount to be paid: 150 card balance: 100", exception.getMessage());
    }

    @Test
    public void testPay4Times() {
        CreditCard card = new CreditCard("1111 2222 3333 4444", 100);
        testSubject.pay(card, 30);
        testSubject.pay(card, 30);
        testSubject.pay(card, 30);

        RuntimeException exception = Assertions.assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.pay(card, 30);
            }
        });
        Assertions.assertEquals("Not enough money in card. Amount to be paid: 30 card balance: 10", exception.getMessage());
    }
}