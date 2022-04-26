package com.aca.homework.week15.repository.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeRepositoryIntegrationTest {

    private CrudRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new EmployeeRepository(new ConnectionFactory());
        testSubject.deleteAll();
    }

    @Test
    public void testSaveAndFindById() {
        Employee testEmployee = new Employee("abcd123456a", "First Name", "Second Name", 54321L);
        testSubject.save(testEmployee);
        Assertions.assertEquals(testEmployee, testSubject.findById("abcd123456a"));
    }

    @Test
    public void testFindAll() {
        Employee testEmployee1 = new Employee("abcd123456a", "First Name", "Second Name", 54321L);
        Employee testEmployee2 = new Employee("aaa22bbb", "Name First", "NameSecond", 12345L);
        testSubject.save(testEmployee1);
        testSubject.save(testEmployee2);
        List<Employee> testList = testSubject.findAll();
        Assertions.assertEquals(testEmployee1, testList.get(0));
        Assertions.assertEquals(testEmployee2, testList.get(1));

    }

    @Test
    public void testDelete() {
        testSubject.deleteAll();
        Assertions.assertEquals(0, testSubject.findAll().size());
    }
}