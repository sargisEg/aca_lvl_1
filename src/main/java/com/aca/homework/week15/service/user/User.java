package com.aca.homework.week15.service.user;

import com.aca.homework.week15.service.user.annotations.Column;
import com.aca.homework.week15.service.user.annotations.Table;

import java.util.Objects;

@Table(name = "USERS")
public class User {

    @Column(name = "username")
    private final String username;

    @Column(name = "name")
    private final String name;

    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!Objects.equals(username, user.username)) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
