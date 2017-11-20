package ru.job4j.crudservlet.ajax;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.crudservlet.Country;
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
 * Class for creating controller which add new user to storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 10.11.2017.
 */
public class JsonAddController extends HttpServlet {
    /**
     * Gson object.
     */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ArrayList<Country> countries = UserStorage.getInstance().getAllCountries();
        String countriesJson = GSON.toJson(countries);
        writer.append(countriesJson);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String role = req.getParameter("role");

        if (UserStorage.getInstance().getUser(login) == null) {
            User user = new User(name, login, password, email, city, country, role);
            UserStorage.getInstance().add(user);
        }
    }


}
