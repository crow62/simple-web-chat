package ru.meleshin.model;

import java.util.Date;

public class Message {

    private Date date;
    private String message;
    private User user;

    public Message(Date date, String message, User user) {
        this.date = date;
        this.message = message;
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
