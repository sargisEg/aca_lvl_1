package com.aca.homework.week4.gun;

public class Gun {
    int cartridges;

    public static void main(String[] args) {
        Gun gun = new Gun();

        gun.fire();
        gun.fire();
        gun.fire();
        gun.fire();
        gun.fire();
        gun.load();
        gun.load();
        gun.fire();
    }

    public Gun(){
        cartridges = 10;
    }

    public void fire(){
        if(cartridges == 0)
            System.out.println("No cartridges");
        else {
            cartridges--;
            System.out.println("fire!");
        }
    }

    public void load(){
        if(cartridges == 10)
            System.out.println("cartridge is full");
        else {
            cartridges++;
            System.out.println("a cartridge is loaded");
        }
    }
}
