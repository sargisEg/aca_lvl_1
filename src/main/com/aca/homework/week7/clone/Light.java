package com.aca.homework.week7.clone;

public class Light implements Cloneable {
    State state;

    private Light(State state) {
        this.state = state;
    }

    public static Light offOff() {
        return new Light(State.OFF);
    }

    public static Light offOn() {
        return new Light(State.ON);
    }

    @Override
    protected Light clone() throws CloneNotSupportedException {
        return new Light(this.state);
    }
}
