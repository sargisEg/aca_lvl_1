package com.aca.homework.week17.note.facade.user;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserSignUpResponseDto {

    private final String username;

    public UserSignUpResponseDto(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserSignUpResponseDto{");
        sb.append("username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUpResponseDto)) return false;
        UserSignUpResponseDto that = (UserSignUpResponseDto) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
