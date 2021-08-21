package ru.meleshin.filters;

import ru.meleshin.dao.UserDaoImpl;
import ru.meleshin.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class FilterExistingUsers implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getSession().getAttribute("exist")==null) {
            httpServletRequest.getSession().setAttribute("exist", "exist");
            chain.doFilter(request,response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/chat.jsp");
            requestDispatcher.forward(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
