package com.aca.homework.week11.occurence;

public class NumberSupplierForTest implements NumberSupplier {

    private int count;

    @Override
    public String getNumber() {
        while (count < 10) {
            count++;
            if(count == 4 || count == 8 || count == 9) {
                return "5";
            }
            return "2";
        }
        return "end";
    }
}
