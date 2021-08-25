package ru.meleshin.dao;

import ru.meleshin.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/h2_web_chat","aaaa","aaaa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static volatile UserDaoImpl instance;

    private UserDaoImpl() {

    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            synchronized (UserDaoImpl.class) {
                if (instance == null) {
                    instance = new UserDaoImpl();
                }
            }
        }
        return instance;
    }


    public void initForH2() {
        try {
            Statement statement = connection.createStatement();
            String SQL = "create table ChatUsers (" +
                    "login varchar, status varchar);";
            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> showAll() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM ChatUsers";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                User user = new User();
                user.setLogin(resultSet.getString("login"));
                user.setStatus(resultSet.getString("status"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public void save(User user) {
        String SQL = "INSERT INTO ChatUsers VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteAll() {
        String SQL = "DELETE FROM ChatUsers";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteByLogin(String login) {
        String SQL = "DELETE FROM ChatUsers WHERE login=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void updateStatus(User user) {

        String SQL = "UPDATE ChatUsers SET status=? WHERE login=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getStatus());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User showByLogin(String login) {
        User user = new User();
        try{
            String SQL = "SELECT * FROM ChatUsers WHERE login=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            user.setLogin(resultSet.getString("login"));
            user.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
