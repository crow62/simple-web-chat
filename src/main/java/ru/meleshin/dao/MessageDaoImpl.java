package ru.meleshin.dao;

import ru.meleshin.model.Message;
import ru.meleshin.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements Dao<Message>{

//    private static final String URL = "jdbc:postgresql://localhost:5432/webchat";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "postgresql";

    private static Connection connection;
    static {
        try {
            //Class.forName("org.postgresql.Driver");
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
            connection = DriverManager.getConnection("jdbc:h2:~/h2_web_chat","aaaa","aaaa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static volatile MessageDaoImpl instance;

    private MessageDaoImpl(){

    }

    public static MessageDaoImpl getInstance() {
        if (instance == null) {
            synchronized (MessageDaoImpl .class) {
                if (instance == null) {
                    instance = new MessageDaoImpl();
                }
            }
        }
        return instance;
    }

    public void initForH2() {
        try {
            Statement statement = connection.createStatement();
            String SQL = "CREATE TABLE ChatMessages (" +
                    "date date, login varchar, message varchar)";
            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Message> showAll() {
        List<Message> messages = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM ChatMessages";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                Message message = new Message();
                message.setDate(resultSet.getTimestamp("date").toLocalDateTime());
                message.setUser(new User(resultSet.getString("login")));
                message.setMessage(resultSet.getString("message"));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public void save(Message message) {
        String SQL = "INSERT INTO ChatMessages VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(message.getDate()));
            preparedStatement.setString(2, message.getUser().getLogin());
            preparedStatement.setString(3, message.getMessage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        String SQL = "DELETE FROM ChatMessages";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
