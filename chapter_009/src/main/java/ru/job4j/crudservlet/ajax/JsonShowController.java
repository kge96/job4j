package ru.job4j.crudservlet.ajax;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(buildJSON());
        writer.flush();
    }

    /**
     * Build json object.
     * @return String.
     */
    public String buildJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ArrayList<User> users = UserStorage.getInstance().getAllUsers();
        int counter = users.size();
        for (User usr : users) {
            counter--;
            sb.append("{");
            sb.append("\"name\":\"" + usr.getName() + "\",");
            sb.append("\"login\":\"" + usr.getLogin() + "\",");
            sb.append("\"email\":\"" + usr.getEmail() + "\",");
            sb.append("\"city\":\"" + usr.getCity() + "\",");
            sb.append("\"country\":\"" + usr.getCountry() + "\",");
            sb.append("\"role\":\"" + usr.getRole() + "\"");
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
