package com.aca.homework.week17.note.facade.user;

public class UserSignUpResponseDto {

    private final String username;

    public UserSignUpResponseDto(String username) {
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
}
