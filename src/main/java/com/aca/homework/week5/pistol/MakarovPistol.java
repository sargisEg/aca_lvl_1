package com.aca.homework.week5.pistol;

public class MakarovPistol extends GunStore{

    public MakarovPistol(String name) {
        super(name);
    }

    @Override
    public void shoot() {
        System.out.print("Makarov ");
        super.shoot();
    }
}
