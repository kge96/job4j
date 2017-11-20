package ru.job4j.crudservlet.ajax;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
 * Class for creating controller which update data on homepage.html.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 10.11.2017.
 */
public class JsonShowController extends HttpServlet {
    /**
     * Gson object.
     */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ArrayList<User> users = UserStorage.getInstance().getAllUsers();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String json = GSON.toJson(users);
        writer.append(json);
        writer.flush();
    }
}
