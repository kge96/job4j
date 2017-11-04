package ru.job4j.crudservlet.servlets;

import ru.job4j.crudservlet.User;
import ru.job4j.crudservlet.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class for creation editing servlet.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.11.2017.
 */
public class Editing extends HttpServlet {
    /**
     * Users database.
     */
    private UserStorage database;

    /**
     * Servlet init method.
     * @throws ServletException - exception.
     */
    @Override
    public void init() throws ServletException {
        super.init();
        database = UserStorage.getInstance();
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
        this.database.update(user);
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
