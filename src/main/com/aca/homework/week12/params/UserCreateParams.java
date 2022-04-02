package com.aca.homework.week12.params;

public class UserCreateParams {

    private final String username;
    private final String firstName;
    private final String age;

    public UserCreateParams(String username, String firstName, String age) {
        this.username = checkForNullAndReturnString(username);
        this.firstName = checkForNullAndReturnString(firstName);
        this.age = checkForNullAndReturnString(age);
    }

    private String checkForNullAndReturnString(String string) {
        if (string == null)
            throw new NullStringException("Value of field cannot be a null");
        return string;
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
