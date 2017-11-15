package ru.job4j.crudservlet.servlets;

import ru.job4j.crudservlet.User;
import ru.job4j.crudservlet.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class - servlet for adding new user to database.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.11.2017.
 */
public class UsersAddController extends HttpServlet {
    /**
     * Users database.
     */
    private UserStorage database;

    @Override
    public void init() throws ServletException {
        super.init();
        database = UserStorage.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String country = req.getParameter("country");
        String city = req.getParameter("city");

        User user = new User(name, login, password, email, city, country, role);
        this.database.add(user);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", UserStorage.getInstance().getAllRoles());
        req.setAttribute("cities", UserStorage.getInstance().getAllCities("Russia"));
        req.setAttribute("countries", UserStorage.getInstance().getAllCountries());
        req.getRequestDispatcher("/WEB-INF/views/UsersAddView.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        database.closeConnections();
    }
}
