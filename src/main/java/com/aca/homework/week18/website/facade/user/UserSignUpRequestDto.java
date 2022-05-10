package com.aca.homework.week18.website.facade.user;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserSignUpRequestDto {

    private final String username;
    private final String firstName;
    private final String secondName;

    public UserSignUpRequestDto(String username, String firstName, String secondName) {
        Assert.hasText(username, "Username should not be null or empty");
        Assert.hasText(firstName, "First name should not be null or empty");
        Assert.hasText(secondName, "Second name should not be null or empty");
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserSignUpRequestDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUpRequestDto)) return false;
        UserSignUpRequestDto that = (UserSignUpRequestDto) o;
        return Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, secondName);
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

}
