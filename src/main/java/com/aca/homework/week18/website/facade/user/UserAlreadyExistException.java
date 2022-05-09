package com.aca.homework.week18.website.facade.user;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String username) {
        super("User with username - " + username + " already exist");
    }
}
