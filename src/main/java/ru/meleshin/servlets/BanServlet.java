package ru.meleshin.servlets;

import ru.meleshin.dao.UserDaoImpl;
import ru.meleshin.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bantext = req.getParameter("bantext");
        User user = UserDaoImpl.getInstance().showByLogin(bantext);
        if(user!=null){
            user.setStatus("ban");
            UserDaoImpl.getInstance().updateStatus(user);
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/chat.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        String status = UserDaoImpl.getInstance().showByLogin(login).getStatus();
        resp.setContentType("text/plain");
        resp.getWriter().write(status.toLowerCase());
    }
}
