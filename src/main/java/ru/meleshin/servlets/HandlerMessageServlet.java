package ru.meleshin.servlets;

import ru.meleshin.dao.MessageDaoImpl;
import ru.meleshin.model.Message;
import ru.meleshin.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class HandlerMessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> paths = (List<String>) req.getSession().getAttribute("userInSystem");
        paths.add(req.getRequestURI());
        req.getSession().setAttribute("userInSystem", paths);

        User user = (User) req.getSession().getAttribute("user");
        String message = req.getParameter("usermsg");

        MessageDaoImpl.getInstance().save(new Message(LocalDateTime.now(), message, user));

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/chat.jsp");
        requestDispatcher.forward(req, resp);

    }

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
