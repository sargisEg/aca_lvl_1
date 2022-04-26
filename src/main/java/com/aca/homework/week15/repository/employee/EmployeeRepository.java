package com.aca.homework.week15.repository.employee;

import com.aca.homework.week15.log.LoggerMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository implements CrudRepository<Employee, String> {
    private final ConnectionFactory connectionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerMain.class);

    public EmployeeRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void save(Employee employee) {
        Connection connection = connectionFactory.getObject();
        try {
            String sql = "insert into employees (id, first_name, second_name, salary)" +
                    " values ('" + employee.getId() + "', '" + employee.getFirstName() +
                    "', '" + employee.getSecondName() + "', " + employee.getSalary() + ")";
            LOGGER.debug(sql);
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findAll() {
        Connection connection = connectionFactory.getObject();
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(
                    "select * from employees");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        List<Employee> employeeList = new LinkedList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            employeeList.add(getEmployeeFromRow(resultSet));
        }

        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public Employee findById(String s) {
        Connection connection = connectionFactory.getObject();
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(
                    "select * from employees where id = '" + s + "'");
            resultSet.next();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Employee employee = getEmployeeFromRow(resultSet);
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    private Employee getEmployeeFromRow(ResultSet resultSet) {
        String id;
        String firstName;
        String secondName;
        long salary;
        try {
            id = (String) resultSet.getObject(1);
            firstName = (String) resultSet.getObject(2);
            secondName = (String) resultSet.getObject(3);
            salary = (long) resultSet.getObject(4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Employee employee = new Employee(id, firstName, secondName, salary);
        LOGGER.debug(employee.toString());
        return employee;
    }

    @Override
    public void deleteAll() {
        Connection connection = connectionFactory.getObject();
        try {
            connection.createStatement().execute("delete from employees");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
