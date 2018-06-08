package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
           String sql = "SELECT * FROM users WHERE username = ?";
           PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, username);
           statement.executeUpdate();
           ResultSet resultSet = statement.getResultSet();
           resultSet.next();
           return extractUserFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error Retrieving User!", e);
        }
    }

    private User extractUserFromResults(ResultSet resultSet) throws SQLException {
        return new User(
            resultSet.getLong("user_id"),
            resultSet.getString("username"),
            resultSet.getString("email")
        );
    }

    @Override
    public Long insert(User user) {
        try {
            String sql =  "INSERT INTO users(username, email, password) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new User.", e);
        }
    }
}