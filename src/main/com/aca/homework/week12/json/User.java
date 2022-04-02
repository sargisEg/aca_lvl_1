package com.aca.homework.week12.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("username")
    private final String userName;

    @JsonProperty("name")
    private final String firstName;

    @JsonProperty("age")
    private final String age;

    public User(String userName, String firstName, String age) {
        this.userName = userName;
        this.firstName = firstName;
        this.age = age;
    }


}
