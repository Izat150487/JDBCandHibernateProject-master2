package com.peaksoft.dao;

import com.peaksoft.model.User;
import com.peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {
    }
//Таблица тузуп жатканда age byte тибинде демек таблицада INT эмес  SMALLINT  болуш керек
    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(40) NOT NULL," +
                "lastName VARCHAR(40) NOT NULL," +
                "age SMALLINT);";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
            System.out.println("Table is create...");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE users";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
            System.out.println("Table is drop");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO users (name,lastName,age) VALUES (?,?,?)";
        try (Connection connection = Util.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            statement.executeUpdate();
            System.out.println("Successfully added " +name);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM users WHERE id = ?";
        try (Connection connection = Util.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1,(int) id);
            statement.executeUpdate();
            System.out.println("The person is delete");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()){
                User user = new User();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        String SQL = "TRUNCATE users";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
            System.out.println("Table is cleaned");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}