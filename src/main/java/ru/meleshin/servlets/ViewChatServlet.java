package ru.meleshin.servlets;

import ru.meleshin.dao.UserDaoImpl;
import ru.meleshin.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ViewChatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserDaoImpl.getInstance().showAll();
        String logins = users.stream()
                .map(User::getLogin)
                .collect(Collectors.joining("\n"));

        resp.setContentType("text/plain");
        resp.getWriter().write(logins);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> paths = new ArrayList<>();
        paths.add(req.getRequestURI());
        req.getSession().setAttribute("userInSystem", paths);

        String login = req.getParameter("login");

        User user = new User(login, "Active");

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("status", user.getStatus());
        req.getSession().setAttribute("user", user);

        UserDaoImpl.getInstance().save(user);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/chat.jsp");
        requestDispatcher.forward(req, resp);

    }

}
