package ru.meleshin.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class HandlerMessageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (((HttpServletRequest) request).getMethod().equalsIgnoreCase("GET")) {
            chain.doFilter(request, response);
        } else {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            if (httpServletRequest.getSession().getAttribute("userInSystem") != null) {
                List<String> paths = (List<String>) httpServletRequest
                        .getSession().getAttribute("userInSystem");

                if (paths.get(paths.size() - 1).contains("/chat") ||
                        paths.get(paths.size() - 1).contains("/msg")) {
                    chain.doFilter(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
                    requestDispatcher.forward(request, response);
                }
            } else chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
