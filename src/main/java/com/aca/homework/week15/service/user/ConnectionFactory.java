package com.aca.homework.week15.service.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:6432/aca", "postgres", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
