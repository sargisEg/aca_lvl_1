package com.aca.homework.week5.pistol;

import java.util.Scanner;

public class PistolTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GunStore[] guns = new GunStore[4];
        for (int i = 0; i < guns.length; i++) {
            System.out.print("Name of a pistol: ");
            guns[i] = givePistol(scanner.next());
        }

        for (int i = 0; i < guns.length; i++) {
            if (guns[i] == null)
                System.out.println("null");
            else
                guns[i].shoot();
        }

    }

    public static GunStore givePistol(String name){
        if (name.equals("air")){
            System.out.println("Giving Air Pistol");
            return new AirPistol("Air Pistol");
        }
        if (name.equals("makarov")){
            System.out.println("Giving Makarov Pistol");
            return new MakarovPistol("Makarov Pistol");
        }
        if (name.equals("nagant")){
            System.out.println("Giving Nagant Pistol");
            return new NagantPistol("Nagant Pistol");
        }
        return null;
    }
}

/*
Imagine a gun seller ask you the name of a pistol and based on that provides you the new pistol.
Gun seller asks you for pistol name 4 times.
After getting pistols shoot each of them.

below is the shoot print message depending on the pistol type

air pistol shoot should print: air pistol fire!
makaraov: makarov fire!!
nagant: nagant pistol fire!!!!!*/