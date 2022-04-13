package com.homework.week7.clone;

import com.aca.homework.week7.clone.Light;

class LightTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Light lightOn = Light.offOn();
        Light lightOff = Light.offOff();

        Light lightOnClone = lightOn.clone();
        Light lightOffClone = lightOff.clone();
    }
}