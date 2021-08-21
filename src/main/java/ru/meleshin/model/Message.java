package ru.meleshin.model;

import java.time.LocalDateTime;

public class Message {

    private LocalDateTime date;
    private String message;
    private User user;

    public Message() {
    }

    public Message(LocalDateTime date, String message, User user) {
        this.date = date;
        this.message = message;
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
