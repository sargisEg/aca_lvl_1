package com.aca.homework.week8.credit_card;

import javax.naming.InsufficientResourcesException;

public class PaymentService {

    public void pay(CreditCard creditCard, int amountToBePaid) {
        creditCard.transfer(amountToBePaid);
        System.out.println("Successfully paid");
    }
}
