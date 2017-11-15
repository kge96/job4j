package ru.job4j.crudservlet.ajax;


import ru.job4j.crudservlet.UserStorage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class for creating controller for leave session.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 10.11.2017.
 */
public class JsonSigninController extends HttpServlet {
    /**
     * Access flag.
     */
    private boolean accessAllowed;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        accessAllowed = UserStorage.getInstance().isCoincided(login, password);

        if (accessAllowed) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
                session.setAttribute("role", UserStorage.getInstance().getUser(login).getRole());
            }
        } else {
           accessAllowed = false;
        }
        doGet(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        if (resp.getStatus() == 401) {
            resp.sendRedirect(String.format("%s/auth.html", req.getContextPath()));
        } else {
            PrintWriter writer = new PrintWriter(resp.getOutputStream());
            String access = String.format("[{\"access\":\"%s\"}, {\"user\":\"%s\", \"role\":\"%s\"}]", this.accessAllowed, req.getSession().getAttribute("login"), req.getSession().getAttribute("role"));

            writer.append(access);
            writer.flush();
        }
    }

}
