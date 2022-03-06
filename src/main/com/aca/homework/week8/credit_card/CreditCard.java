package com.aca.homework.week8.credit_card;

import java.util.Objects;

public class CreditCard {
    private int balance;
    private String number;

    public CreditCard(String number, int balance) {
        this.balance = balance;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card number: " + number + "\nbalance: " + balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof CreditCard) {
            CreditCard card = (CreditCard) o;
            return this.number.equals(card.number);
        }
        return false;
    }

    public void transfer(int amount) {
        if (amount > this.balance)
            throw new InsufficientBalanceException(amount, this.balance);
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }
}
