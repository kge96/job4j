package ru.job4j.crudservlet.ajax;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class for creating signout controller.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 08.11.2017.
 */
public class JsonSignoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        synchronized (session) {
            session.invalidate();
        }
    }
}
