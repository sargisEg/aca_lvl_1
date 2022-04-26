package com.aca.homework.week16.organization.create.params;

import org.springframework.util.Assert;

public class UserCreateParams {

    private final String first_name;
    private final String second_name;

    public UserCreateParams(String first_name, String second_name) {
        Assert.hasText(first_name, "First Name should not be null or empty");
        Assert.hasText(second_name, "Second Name should not be null or empty");
        this.first_name = first_name;
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserCreateParams{");
        sb.append("first_name='").append(first_name).append('\'');
        sb.append(", second_name='").append(second_name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
