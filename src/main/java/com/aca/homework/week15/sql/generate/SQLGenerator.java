package com.aca.homework.week15.sql.generate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLGenerator {

    public String generateInsert(User user) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:6432/aca", "postgres", ""
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String insertSQL = "insert into users (full_name, age) values ('" + user.getName() + "', " + user.getAge() + ")";
        try {
            connection.createStatement().execute(insertSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return insertSQL;
    }

}
