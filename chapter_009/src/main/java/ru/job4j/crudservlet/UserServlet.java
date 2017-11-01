package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Class for creating UserServlet.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 31.10.2017.
 */
public class UserServlet extends HttpServlet {
    /**
     * Users database.
     */
    private UsersDBConnector database;

    /**
     * Servlet init method.
     * @throws ServletException - exception.
     */
    @Override
    public void init() throws ServletException {
        super.init();
        database = new UsersDBConnector();
    }

    /**
     * Get method.
     * @param req - request object.
     * @param resp - response object.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        User user = database.getUser(login);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(String.format("User: name - %s, login - %s, email - %s, creating date - %s", user.getName(), user.getLogin(), user.getEmail(), user.getCreated()));
        writer.flush();
    }

    /**
     * Post method.
     * @param req - request object.
     * @param resp - response object.
     * @throws ServletException- exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        User user = new User(name, login, email);
        this.database.add(user);
        doGet(req, resp);

    }

    /**
     * Put method.
     * @param req - request object.
     * @param resp - response object.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        User user = this.database.getUser(login);
        user.setEmail(email);
        user.setName(name);
        user.setEmail(email);
        this.database.update(user);
    }

    /**
     * Delete method.
     * @param req - request object.
     * @param resp - response object.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        this.database.delete(login);
    }

    /**
     * Destroy method. Exicute before servlet finishing.
     */
    @Override
    public void destroy() {
        super.destroy();
        database.closeConnections();
    }
}
