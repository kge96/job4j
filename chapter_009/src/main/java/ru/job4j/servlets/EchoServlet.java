package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Class for testing servlets.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 31.10.2017.
 */
public class EchoServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);

    /**
     * Collection.
     */
    private List<String> users = new CopyOnWriteArrayList<>();

    /**
     * Get connection.
     * @param req - request.
     * @param resp - resp.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("hellow world, " + this.users);
        writer.flush();
    }

    /**
     * Post method.
     * @param req - request.
     * @param resp - response.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.users.add(req.getParameter("login"));
        doGet(req, resp);
    }
}
