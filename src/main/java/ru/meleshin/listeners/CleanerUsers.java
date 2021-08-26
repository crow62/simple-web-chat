package ru.meleshin.listeners;

import ru.meleshin.dao.MessageDaoImpl;
import ru.meleshin.dao.UserDaoImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CleanerUsers implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        UserDaoImpl.getInstance().deleteAll();
    }
}
