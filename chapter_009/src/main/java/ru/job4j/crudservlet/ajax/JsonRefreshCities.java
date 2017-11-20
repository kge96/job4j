package ru.job4j.crudservlet.ajax;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.crudservlet.City;
import ru.job4j.crudservlet.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class for creating controller which take cities when user choose country.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 14.11.2017.
 */
public class JsonRefreshCities extends HttpServlet {
    /**
     * Gson object.
     */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    /**
     * Country which choosed user.
     */
    private String country;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        ArrayList<City> cities = UserStorage.getInstance().getAllCities(country);
        String json = GSON.toJson(cities);
        writer.append(json);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.country = req.getParameter("country");
        doGet(req, resp);
    }

}
