package com.aca.homework.week12.params;

public class UserUpdateParams {

    private final String username;
    private final String firstName;
    private final String age;

    public UserUpdateParams(String username, String firstName, String age) {
        this.username = setNotNullString(username);
        this.firstName = setNotNullString(firstName);
        this.age = setNotNullString(age);
    }

    private String setNotNullString(String string) {
        return string == null ? "" : string;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAge() {
        return age;
    }
}
