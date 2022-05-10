package com.aca.homework.week17.note.service.core;

import org.springframework.util.Assert;

public class CreateUserParams {

    private final String username;

    private final String firstName;

    private final String secondName;

    public CreateUserParams(String username, String firstName, String secondName) {
        Assert.hasText(username, "Username should not be null or empty");
        Assert.hasText(firstName, "First Name should not be null or empty");
        Assert.hasText(secondName, "Second Name should not be null or empty");
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateUserParams{");
        sb.append("username='").append(username).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
