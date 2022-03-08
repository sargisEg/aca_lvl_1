package com.aca.homework.week9.donate;

public class Smartphone implements Donatable {

    double price;

    @Override
    public double donationAmount() {
        return price * 0.05;
    }

    public Smartphone(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Smartphone";
    }
}
