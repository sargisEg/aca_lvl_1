package com.aca.homework.week4.developer;

public class Developer {

    private String name;

    public int getSalary() {
        return 60_000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLearningBudget() {
        return 300;
    }

    public void print() {
        System.out.println("Name: " + getName() + ", salary: " + getSalary() + ", learning budget: " + getLearningBudget());
    }
}

/*Create a Developer class that has a name field.
The Developer class should have getSalary method that returns a fixed 60_000 value.
Create name setter and getter methods.
The Developer class should also have getLearningBudget method that returns a fixed 300 value.*/