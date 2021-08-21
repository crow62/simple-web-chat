package ru.meleshin.dao;

import ru.meleshin.model.Message;
import ru.meleshin.model.User;

import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements Dao<Message>{
    public static volatile MessageDaoImpl instance;

    private List<Message> messages;

    private MessageDaoImpl(){
        messages = new ArrayList<>();
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

    @Override
    public List<Message> showAll() {
        return messages;
    }

    @Override
    public void save(Message message) {
        messages.add(message);
    }
}
