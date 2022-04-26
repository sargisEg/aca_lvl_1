package com.aca.homework.week12.params;

public class UserCreateParams {

    private final String username;
    private final String firstName;
    private final int age;

    public UserCreateParams(String username, String firstName, Integer age) {
        this.username = checkForNullAndReturnString(username);
        this.firstName = checkForNullAndReturnString(firstName);
        this.age = checkForNullAndReturnInt(age);
    }

    private int checkForNullAndReturnInt(Integer age) {
        if (age == null)
            throw new NullFieldException("Value of field cannot be a null");
        return age;
    }

    private String checkForNullAndReturnString(String string) {
        if (string == null)
            throw new NullFieldException("Value of field cannot be a null");
        return string;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}
