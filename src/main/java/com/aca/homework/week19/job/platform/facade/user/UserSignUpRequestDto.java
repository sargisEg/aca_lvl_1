package com.aca.homework.week19.job.platform.facade.user;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserSignUpRequestDto {

    private String username;
    private String name;

    public UserSignUpRequestDto(String username, String name) {
        Assert.hasText(
                username,
                "Class - UserSignUpRequestDto, " +
                        "method - UserSignUpRequestDto(String username, String name) " +
                        "username should not be null or empty"
        );
        Assert.hasText(
                name,
                "Class - UserSignUpRequestDto, " +
                        "method - UserSignUpRequestDto(String username, String name) " +
                        "name should not be null or empty"
        );
        this.username = username;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserSignUpRequestDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUpRequestDto)) return false;
        UserSignUpRequestDto that = (UserSignUpRequestDto) o;
        return Objects.equals(username, that.username) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
