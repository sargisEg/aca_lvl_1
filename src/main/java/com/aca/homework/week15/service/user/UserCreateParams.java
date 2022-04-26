package com.aca.homework.week15.service.user;

import com.aca.homework.week12.params.NullFieldException;

public class UserCreateParams {

    private final String username;
    private final String name;

    public UserCreateParams(String username, String name) {
        if (username == null || name == null) {
            throw new NullFieldException("username and/or name should not be null");
        }
        this.username = username;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }
}
