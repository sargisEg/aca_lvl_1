package com.aca.homework.week5.pistol;

public class NagantPistol extends GunStore{

    public NagantPistol(String name) {
        super(name);
    }

    @Override
    public void shoot() {
        System.out.print("agant pistol ");
        super.shoot();
    }
}
