package ru.meleshin.servlets;

import ru.meleshin.dao.MessageDaoImpl;
import ru.meleshin.dao.UserDaoImpl;
import ru.meleshin.model.Message;
import ru.meleshin.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class MessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        String message = req.getParameter("usermsg");
        MessageDaoImpl.getInstance().save(new Message(new Date(),message, user));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/chat.jsp");
        requestDispatcher.forward(req, resp);
    }
}
