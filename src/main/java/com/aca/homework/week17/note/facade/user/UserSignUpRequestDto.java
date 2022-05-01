package com.aca.homework.week17.note.facade.user;

public class UserSignUpRequestDto {

    private final String username;

    private final String firstName;

    private final String secondName;

    public UserSignUpRequestDto(String username, String firstName, String secondName) {
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
        final StringBuilder sb = new StringBuilder("UserSignUpRequestDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
