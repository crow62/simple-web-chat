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


public class AuthorizationServlet extends HttpServlet {





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> paths = new ArrayList<>();
        paths.add(req.getRequestURI());
        System.out.println(req.getRequestURI());
        req.getSession().setAttribute("userInSystem", paths);


        String login = req.getParameter("login");

        User user = new User(login);

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("user", user);

        UserDaoImpl.getInstance().save(user);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/chat.jsp");
        requestDispatcher.forward(req, resp);
    }

}
