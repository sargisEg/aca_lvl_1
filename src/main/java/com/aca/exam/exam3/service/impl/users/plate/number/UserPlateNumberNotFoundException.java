package com.aca.exam.exam3.service.impl.users.plate.number;

public class UserPlateNumberNotFoundException extends RuntimeException {
    public UserPlateNumberNotFoundException(Long plateNumberId) {
        super("Not found user plate number with plate number id - " + plateNumberId);
    }
}
