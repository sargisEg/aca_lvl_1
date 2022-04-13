package com.aca.homework.week11.hash;

import java.util.Objects;

public class Singer {

    private final String firstName;
    private final String lastName;

    public Singer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof Singer) {
            return Objects.equals(this.firstName, ((Singer) o).firstName)
                    && Objects.equals(this.lastName, ((Singer) o).lastName);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ?lastName.hashCode() : 0);
        return result;
    }
}
