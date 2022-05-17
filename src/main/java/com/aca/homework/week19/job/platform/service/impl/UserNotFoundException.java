package com.aca.homework.week19.job.platform.service.impl;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("Not found user with id - " + userId);
    }
}
