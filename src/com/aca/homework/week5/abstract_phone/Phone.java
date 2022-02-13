package com.aca.homework.week5.abstract_phone;

import java.util.Objects;

public class Phone {
    private Model model;
    private String imei;

    public Phone(Model model, String imei) {
        this.model = model;
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Phone){
            return this.imei.equals(((Phone) o).imei);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Phone " +
                "model: " + model +
                ", imei: " + imei + "\n";
    }
}

/*
Implement the equals and toString methods of the Phone class.
 */