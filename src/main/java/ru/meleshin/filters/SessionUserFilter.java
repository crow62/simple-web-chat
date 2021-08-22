package ru.meleshin.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SessionUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        Object exist = httpServletRequest.getSession().getAttribute("exist");
//        if (exist==null) {
//            httpServletRequest.getSession().setAttribute("exist", "exist");
//            chain.doFilter(request,response);
//        } else {
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/chat.jsp");
//            requestDispatcher.forward(request, response);
//        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
