package ru.meleshin.filters;

import ru.meleshin.dao.UserDaoImpl;
import ru.meleshin.model.User;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class RegisteredUsersFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String login = request.getParameter("login");
        User user = new User(login);
        List<User> users = UserDaoImpl.getInstance().showAll();
        if(users.contains(user)){
            request.setAttribute("error", "Такой логин занят, введите другой!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
            requestDispatcher.forward(request, response);
        } else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
