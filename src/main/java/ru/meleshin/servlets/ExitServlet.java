package ru.meleshin.servlets;

import ru.meleshin.dao.UserDaoImpl;
import ru.meleshin.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExitServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("userInSystem", null);

        String login = (String)req.getSession().getAttribute("login");

        UserDaoImpl.getInstance().deleteByLogin(login);

        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());

    }
}
