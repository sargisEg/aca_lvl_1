package com.aca.homework.week5.equals;

public class Motorcycle {
    private Owner owner;
    private Brand brand;

    public Motorcycle(Owner owner, Brand brand) {
        this.owner = owner;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Motorcycle of " + brand + " type\n"
                + "owner: " + owner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Motorcycle) {
            return this.owner.equals(((Motorcycle) o).owner) &&
                    this.brand.equals(((Motorcycle) o).brand);
        }
        return false;
    }

}

/*
Create a Motorcycle class that has a brand (SUZUKI, YAMAHA is allowed only) and an owner.
Implement toString and equals methods of Motorcycle class.
*/