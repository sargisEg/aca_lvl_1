package com.aca.homework.week18.website.facade.user;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserSignUpResponseDto {


    private final Long id;
    private final String username;

    public UserSignUpResponseDto(Long id, String username) {
        Assert.hasText(username, "Username should not be null or empty");
        Assert.notNull(id, "User id should not be null");
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserSignUpResponseDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUpResponseDto)) return false;
        UserSignUpResponseDto that = (UserSignUpResponseDto) o;
        return Objects.equals(username, that.username) &&  Objects.equals(id, that.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, id);
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }
}
