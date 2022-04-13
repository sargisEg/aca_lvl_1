package com.aca.homework.week10.user.repository;

import java.util.Objects;

public class User {

    private Long id;
    private String username;
    private int age;

    public User(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User: " +
                "id = " + id +
                ", username = " + username +
                ", age = " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.id.equals(user.id);
    }
}
