package ru.job4j.crudservlet.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class for creating controller which check session.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 12.11.2017.
 */
public class JsonAuthFilter implements Filter {
        /**
         * Logger.
         */
        private static Logger log = LoggerFactory.getLogger(ru.job4j.crudservlet.servlets.AuthFilter.class);

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) req;
            if (request.getSession().getAttribute("login") == null && !((HttpServletRequest) req).getRequestURI().contains("/auth.html")) {
                ((HttpServletResponse) resp).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                request.getRequestDispatcher("./auth").forward(request, resp);
            } else {
                chain.doFilter(req, resp);
            }
        }

        @Override
        public void destroy() { }
}

