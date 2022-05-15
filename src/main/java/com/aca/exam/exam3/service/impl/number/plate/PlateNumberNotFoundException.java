package com.aca.exam.exam3.service.impl.number.plate;

public class PlateNumberNotFoundException extends RuntimeException {
    public PlateNumberNotFoundException(Long id) {
        super("Not found plate number with id - " + id);
    }

    public PlateNumberNotFoundException(String plateNumber) {
        super("Not found plate number - " + plateNumber);
    }
}
