package com.aca.homework.week5.equals;

import java.util.Objects;

public class Owner {
    private String firstName;
    private String lastName;

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Owner) {
            return this.firstName.equals(((Owner) o).firstName)
                    && this.lastName.equals(((Owner) o).lastName);
        }
        return false;
    }
}
/*
Create an Owner class that has firstName and lastName. Implement toString and equals method.
Create a Motorcycle class that has a brand (SUZUKI, YAMAHA is allowed only) and an owner.
Implement toString and equals methods of Motorcycle class.
Create a Motorcycle of YAMAHA type owner of which is 'Yorgantz' 'Mark.
Create a Motorcycle of YAMAHA type owner of which is 'Tavares 'Mark.
print the above objects, compare them and print the result.
*/