package ru.job4j.crudservlet.servlets;

import ru.job4j.crudservlet.User;
import ru.job4j.crudservlet.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class for creating user edit controller.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 07.11.2017.
 */
public class UserEditController extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", UserStorage.getInstance().getAllRoles());
        req.setAttribute("countries", UserStorage.getInstance().getAllCountries());
        req.setAttribute("cities", UserStorage.getInstance().getAllCities("Russia"));
        String login = req.getParameter("name");
        User user = UserStorage.getInstance().getUser(login);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/views/UserEditView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        String oldLogin = req.getParameter("oldLogin");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String city = req.getParameter("city");
        String country = req.getParameter("country");

        User user = new User(name, login, password, email, city, country, role);
        this.database.update(user, oldLogin);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
//        if (session.getAttribute("role").equals("admin")) {
//            resp.sendRedirect(String.format("%s/", req.getContextPath()));
//        } else {
//            synchronized (session) {
//                session.invalidate();
//            }
//            resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
//        }
    }

    @Override
    public void destroy() {
        super.destroy();
        database.closeConnections();
    }
}

