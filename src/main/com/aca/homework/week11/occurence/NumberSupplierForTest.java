package com.aca.homework.week11.occurence;

public class NumberSupplierForTest implements NumberSupplier {

    private int count = -1;
    private String[] numbers;

    public NumberSupplierForTest(String[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String getNumber() {
        count++;
        return numbers[count];
    }
}
