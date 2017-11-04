package ru.job4j.crudservlet.servlets;

import ru.job4j.crudservlet.User;
import ru.job4j.crudservlet.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class - servlet for adding new user to database.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.11.2017.
 */
public class Creation extends HttpServlet {
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
     * Get-method.
     * @param req - request.
     * @param resp - response.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder("<table>");

        printWriter.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Title</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <form action= '" + req.getContextPath() + "/user/add' method=\"post\">\n"
                + "        <h3>Name:</h3><input type=\"text\" name=\"name\"/>\n"
                + "        <h3>login:</h3> <input type=\"text\" name = \"login\"/>\n"
                + "        <h3>email:</h3> <input type=\"text\" name = \"email\"/></br></br>\n"
                + "        <input type = \"submit\" value = \"add user\">\n"
                +        "<a href=\"../user\">back</a>\n"
                + "    </form>\n"
                + "</body>\n"
                + "</html>");
        printWriter.flush();
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
