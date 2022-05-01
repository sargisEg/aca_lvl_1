package com.aca.homework.week17.note.service.impl;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super("Not found user with id - " + id);
    }

    public UserNotFoundException(String username) {
        super("Not found user with username - " + username);
    }
}
