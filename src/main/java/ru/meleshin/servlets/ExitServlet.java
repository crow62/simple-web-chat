package ru.meleshin.servlets;

import ru.meleshin.dao.UserDaoImpl;
import ru.meleshin.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String)req.getSession().getAttribute("login");

        UserDaoImpl.getInstance().delete(new User(login));

        req.getSession().invalidate();
        req.getSession().setAttribute("exist", null);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }
}
