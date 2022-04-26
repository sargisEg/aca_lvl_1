package com.aca.homework.week15.service.user;

import java.sql.Connection;
import java.sql.SQLException;

public class UserRepository {

    private final ConnectionFactory connectionFactory;

    public UserRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void save(User user) {
        Connection connection = connectionFactory.getConnection();

        String sql = new SQLGenerator().generateSave(user);

        try {
            connection.createStatement().execute(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
