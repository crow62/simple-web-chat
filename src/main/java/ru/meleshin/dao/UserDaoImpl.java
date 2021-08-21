package ru.meleshin.dao;

import ru.meleshin.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {

    public static volatile UserDaoImpl instance;

    private List<User> users;

    private UserDaoImpl(){
        users = new ArrayList<>();
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
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    public void delete(String login) {
        users.removeIf(p->p.getLogin().equals(login));
    }


}
