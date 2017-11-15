package ru.job4j.crudservlet.servlets;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;


/**
 * Class for creating filter.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 07.11.2017.
 */
public class AuthFilter implements Filter {
    /**
     * Logger.
     */
    private static Logger log = LoggerFactory.getLogger(AuthFilter.class);

    /**
     * Init method.
     * @param filterConfig - filter config.
     * @throws ServletException - exception.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Start do filter.
     * @param req - request.
     * @param resp - response.
     * @param chain - chain.
     * @throws IOException - exception.
     * @throws ServletException - exception.
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().contains("/signin")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session =  request.getSession();
            synchronized (session) {
                if (session.getAttribute("login") == null) {
                    ((HttpServletResponse) resp).sendRedirect(String.format("%s/signin", request.getContextPath()));
                    return;
                }
            }
            chain.doFilter(req, resp);
        }
    }

    /**
     *
     */
    @Override
    public void destroy() {

    }
}
