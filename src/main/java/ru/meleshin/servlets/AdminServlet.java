package ru.meleshin.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = "user";
        String login = (String)req.getSession().getAttribute("login");
        if(login.equalsIgnoreCase("admin")){
            role = login;
        }
        resp.setContentType("text/plain");
        resp.getWriter().write(role.toLowerCase());
    }
}
