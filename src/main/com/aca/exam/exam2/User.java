package com.aca.exam.exam2;

import java.util.Objects;

public class User {

    private final String id;
    private final String firstName;
    private final String lastName;

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof User) {
            return Objects.equals(id, ((User) o).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User {" +
                " id: " + id +
                ", firstName: " + firstName +
                ", lastName: " + lastName +
                " }";
    }
}
