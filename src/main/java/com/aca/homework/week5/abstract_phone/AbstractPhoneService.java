package com.aca.homework.week5.abstract_phone;

public abstract class AbstractPhoneService {
    public abstract Phone create(String imei, Model model);
    public abstract Phone getByImei(String imei);
}

/*
Create an AbstractPhoneService class that has 2 public abstract methods:
Phone create(String imei, Model model);
Phone getByImei(String imei);
*/
