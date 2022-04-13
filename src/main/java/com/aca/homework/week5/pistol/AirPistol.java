package com.aca.homework.week5.pistol;

public class AirPistol extends GunStore{

    public AirPistol(String name) {
        super(name);
    }

    @Override
    public void shoot() {
        System.out.print("Air Pistol ");
        super.shoot();
    }
}
