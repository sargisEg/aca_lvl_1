package com.aca.homework.week15.sql.generate;


import java.sql.Connection;
import java.sql.SQLException;

public class UserCrudRepository {

    private final Connection connection;
    private final SQLGenerator sqlGenerator;

    public UserCrudRepository(Connection connection) {
        this.connection = connection;
        this.sqlGenerator = new SQLGenerator();
    }

    public User save(User user) {

        try {
            connection.createStatement().execute(sqlGenerator.generateInsert(user));
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
