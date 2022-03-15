package com.aca.homework.week10.user.repository;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(User user) {
        super(user + " not found");
    }
}
