package com.aca.homework.week8.credit_card;

import javax.naming.InsufficientResourcesException;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(int amount, int balance) {
        super("Not enough money in card. Amount to be paid: " + amount
                + " card balance: " + balance);
    }
}
