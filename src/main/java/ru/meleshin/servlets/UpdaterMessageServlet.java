package ru.meleshin.servlets;

import ru.meleshin.dao.MessageDaoImpl;
import ru.meleshin.model.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class UpdaterMessageServlet extends HttpServlet {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messages = MessageDaoImpl.getInstance().showAll();

        String userMessage = messages.stream()
                .map(p -> p.getDate().format(formatter) + " " +
                        p.getUser().getLogin() + ": " + p.getMessage())
                .collect(Collectors.joining("\n"));

        resp.setContentType("text/plain");
        resp.getWriter().write(userMessage);
    }

}
