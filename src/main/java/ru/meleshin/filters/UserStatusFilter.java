package ru.meleshin.filters;


import ru.meleshin.dao.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class UserStatusFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String login = (String)httpServletRequest.getSession().getAttribute("login");

        if (((HttpServletRequest) request).getMethod().equalsIgnoreCase("POST")
        && UserDaoImpl.getInstance().showByLogin(login).getStatus()=="ban") {
            ((HttpServletResponse)response).
                    sendRedirect(((HttpServletRequest) request).getContextPath()+"/chatban.jsp");
        }
        else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
