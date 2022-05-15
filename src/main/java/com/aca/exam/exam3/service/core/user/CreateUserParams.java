package com.aca.exam.exam3.service.core.user;

import org.springframework.util.Assert;

import java.util.Objects;

public class CreateUserParams {

    private final String passportId;

    private final String firstName;

    private final String secondName;

    public CreateUserParams(String passportId, String firstName, String secondName) {
        Assert.notNull(passportId, "The passport id should not be null");
        Assert.hasText(firstName, "First name should not be null or empty");
        Assert.hasText(secondName, "Second name should not be null or empty");
        this.passportId = passportId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getPassportId() {
        return passportId;
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
        sb.append("passportId=").append(passportId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserParams)) return false;
        CreateUserParams that = (CreateUserParams) o;
        return Objects.equals(passportId, that.passportId) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId, firstName, secondName);
    }
}
