package com.aca.homework.week16.organization.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Not found User with id: " + id);
    }
}
