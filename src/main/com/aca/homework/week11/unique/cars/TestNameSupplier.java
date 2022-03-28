package com.aca.homework.week11.unique.cars;

public class TestNameSupplier implements NameSupplier {

    private int count = -1;
    private final String[] names;

    public TestNameSupplier(String... names) {
        this.names = names;
    }

    @Override
    public String get() {
        count++;
        return names[count];
    }
}
