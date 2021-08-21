package ru.meleshin.servlets;

import ru.meleshin.dao.MessageDaoImpl;
import ru.meleshin.dao.UserDaoImpl;
import ru.meleshin.model.Message;
import ru.meleshin.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class FieldServlet extends HttpServlet {

    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        List<Message> messages = MessageDaoImpl.getInstance().showAll();
        String userMessage = messages.stream()
                .map(p -> formatter.format(p.getDate()) + " " +
                        p.getUser().getLogin() + ": " + p.getMessage())
                .collect(Collectors.joining("\n"));

     //  System.out.println(userMessage);
        resp.setContentType("text/plain");
        resp.getWriter().write(userMessage);
    }
}
