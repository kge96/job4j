package ru.job4j.crudservlet.servlets;

import ru.job4j.crudservlet.User;
import ru.job4j.crudservlet.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class for creation getting servlet.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.11.2017.
 */
public class Getting extends HttpServlet {
    /**
     * Database.
     */
    private UserStorage database;

    /**
     * Init method.
     * @throws ServletException - exception.
     */
    @Override
    public void init() throws ServletException {
        super.init();
        database = UserStorage.getInstance();
    }

    /**
     * Get method.
     * @param req - request.
     * @param resp - response.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ArrayList<User> users = database.getAllUsers();
        StringBuilder sb = new StringBuilder("<table>");
        for (User usr : users) {
            sb.append("<tr><td>" + usr.getName() + "</td><td>" + usr.getLogin() + "</td><td>" + usr.getEmail() + "</td><tr>");
        }
        sb.append("</table>");
        sb.append("<input type=\"submit\" value = \"edit\">");
        sb.append("<input type=\"submit\" value = \"delete\"></br>");
        sb.append("<a href = \"user/add\">add user</a>");

        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(sb.toString());
        writer.flush();
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
