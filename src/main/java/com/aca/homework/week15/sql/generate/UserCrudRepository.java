package com.aca.homework.week15.sql.generate;


import java.sql.Connection;
import java.sql.SQLException;

public class UserCrudRepository {

    private final Connection connection;

    public UserCrudRepository(Connection connection) {
        this.connection = connection;
    }

    public User save(User user) {

        try {
            connection.createStatement().execute(new SQLGenerator().generateInsert(user));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
