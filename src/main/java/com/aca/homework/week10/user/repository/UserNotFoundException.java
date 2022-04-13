package com.aca.homework.week10.user.repository;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User with id: " + id + " not found");
    }
}
