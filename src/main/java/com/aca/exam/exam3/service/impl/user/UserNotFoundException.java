package com.aca.exam.exam3.service.impl.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Not found user with id - " + id);
    }
}
