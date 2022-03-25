package com.aca.homework.week11.unique.cars;

public class TestNameInput implements NameInput {

    private int count = -1;
    private final String[] names;

    public TestNameInput(String... names) {
        this.names = names;
    }

    @Override
    public String ask() {
        count++;
        return names[count];
    }
}
