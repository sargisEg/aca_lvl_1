package com.aca.exam.exam3.facade;

public class NumberTakenException extends RuntimeException {
    public NumberTakenException(String plateNumber) {
        super("Plate with number " + plateNumber + " already taken");
    }
}
