package com.aca.homework.week5.abstract_phone;

public class PhoneService extends AbstractPhoneService{

    private Phone[] phones = new Phone[16];
    private int index = 0;

    @Override
    public Phone create(String imei, Model model) {
        if (getByImei(imei) == null) {
            phones[index] = new Phone(model, imei);
            index++;
            return phones[index-1];
        }
        return getByImei(imei);
    }

    @Override
    public Phone getByImei(String imei) {
        for (int i = 0; i < index; i++) {
            if (phones[i].getImei().equals(imei)){
                return phones[i];
            }
        }
        return null;
    }
}

/*
Create a PhoneService class that extends from AbstractPhoneService
and has implementations of the abstract methods.

When a user passes an IMEI and model to the create method,
 PhoneService class creates a Phone object, keeps it in a private array, and returns the newly created object.

When a user invokes the getByImei method,
PhoneService class finds and returns the Phone object out of the private array.

*/
