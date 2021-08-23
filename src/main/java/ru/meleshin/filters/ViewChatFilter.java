package ru.meleshin.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewChatFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (((HttpServletRequest) request).getMethod().equalsIgnoreCase("GET")) {
            if (httpServletRequest.getSession().getAttribute("userInSystem") == null) {
                ((HttpServletResponse)response).
                        sendRedirect(((HttpServletRequest) request).getContextPath());
            } else
            chain.doFilter(request, response);
        } else chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }

}
