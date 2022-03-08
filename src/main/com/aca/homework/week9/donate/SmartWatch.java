package com.aca.homework.week9.donate;

public class SmartWatch implements Donatable {

    double price;

    public SmartWatch(double price) {
        this.price = price;
    }

    @Override
    public double donationAmount() {
        return price * 0.05;
    }

    @Override
    public String toString() {
        return "Smart Watch";
    }
}
