package ru.job4j.crudservlet.ajax;

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
     * Country which choosed user.
     */
    private String country;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        ArrayList<String> cities = UserStorage.getInstance().getAllCities(country);

        writer.append(buildJSON(cities));
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.country = req.getParameter("country");
        doGet(req, resp);
    }

    /**
     * Build json object.
     * @param cities - cities.
     * @return String.
     */
    public String buildJSON(ArrayList<String> cities) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int counter = cities.size();
        for (String city : cities) {
            counter--;
            sb.append("{");
            sb.append(String.format("\"city\":\"%s\"", city));
            if (counter == 0) {
                sb.append("}");
            } else {
                sb.append("},");
            }

        }
        sb.append("]");
        return sb.toString();
    }
}
