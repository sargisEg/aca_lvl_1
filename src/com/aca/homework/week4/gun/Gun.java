package com.aca.homework.week4.gun;

public class Gun {
    int[] cartridges;
    int point;

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
        cartridges = new int[10];
        for (int i = 0; i < cartridges.length; i++) {
            cartridges[i] = 1;
        }
        point = 10;
    }

    public void fire(){
        if(point == 0)
            System.out.println("No cartridges");
        else {
            point--;
            cartridges[point] = 0;
            System.out.println("fire!");
        }
    }

    public void load(){
        if(point == 10)
            System.out.println("cartridge is full");
        else {
            cartridges[point] = 1;
            point++;
            System.out.println("a cartridge is loaded");
        }
    }
}
