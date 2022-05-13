package com.aca.homework.week19.job.platform.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public class CreateUserParams {

    private final String username;
    private final String name;
    private final boolean isOpenForOffers;


    public CreateUserParams(String username, String name, boolean isOpenForOffers) {
        Assert.hasText(
                username,
                "Class - CreateUserParams, method - CreateUserParams(String username, String name, boolean isOpenForOffers) username should not be null or empty"
        );
        Assert.hasText(
                name,
                "Class - CreateUserParams, method - CreateUserParams(String username, String name, boolean isOpenForOffers) name should not be null or empty");
        this.username = username;
        this.name = name;
        this.isOpenForOffers = isOpenForOffers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateUserParams{");
        sb.append("username='").append(username).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", isOpenForOffers='").append(isOpenForOffers).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserParams)) return false;
        CreateUserParams that = (CreateUserParams) o;
        return Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(isOpenForOffers, that.isOpenForOffers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, isOpenForOffers);
    }

    public boolean isOpenForOffers() {
        return isOpenForOffers;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
}
