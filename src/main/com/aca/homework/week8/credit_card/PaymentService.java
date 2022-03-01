package com.aca.homework.week8.credit_card;

import javax.naming.InsufficientResourcesException;

public class PaymentService {

    public void pay(CreditCard creditCard, int amountToBePaid) {
        if (creditCard.getBalance() >= amountToBePaid) {
            creditCard.transfer(amountToBePaid);
            System.out.println("Successfully paid");
        } else {
            throw new InsufficientBalanceException("Not enough money in card. Amount to be paid: " + amountToBePaid
                    + " card balance: " + creditCard.getBalance());
        }
    }
}
