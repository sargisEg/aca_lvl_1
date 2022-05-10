package com.aca.homework.week18.website.service.impl;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("Not found user with id - " + userId);
    }
}
