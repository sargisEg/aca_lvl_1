package com.aca.homework.week8.credit_card;

import javax.naming.InsufficientResourcesException;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String explanation) {
        super(explanation);
    }

    public InsufficientBalanceException() {
    }
}
