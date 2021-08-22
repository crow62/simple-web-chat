package ru.meleshin.dao;

import ru.meleshin.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {

    private static final String URL = "jdbc:postgresql://localhost:5432/webchat";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgresql";

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.DriverManager");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static volatile UserDaoImpl instance;

    private UserDaoImpl(){

    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            synchronized (UserDaoImpl .class) {
                if (instance == null) {
                    instance = new UserDaoImpl();
                }
            }
        }
        return instance;
    }


    @Override
    public List<User> showAll() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM ChatUsers";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                User user = new User();
                user.setLogin(resultSet.getString("login"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public void save(User user) {
        String SQL = "INSERT INTO ChatUsers VALUES(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void delete(User user) {
        String SQL = "DELETE FROM ChatUsers WHERE login=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     public void deleteAll() {
         String SQL = "delete from chatusers";
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }


}
