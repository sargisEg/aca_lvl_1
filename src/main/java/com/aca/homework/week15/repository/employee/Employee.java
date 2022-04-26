package com.aca.homework.week15.repository.employee;

import java.util.Objects;

public class Employee {

    private final String id;
    private final String firstName;
    private final String secondName;
    private final Long salary;

    public Employee(String id, String firstName, String secondName, Long salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Long getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(id, employee.id)) return false;
        if (!Objects.equals(firstName, employee.firstName)) return false;
        if (!Objects.equals(secondName, employee.secondName)) return false;
        return Objects.equals(salary, employee.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
