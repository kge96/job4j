package ru.job4j.crudservlet.servlets;

import org.junit.Test;
import ru.job4j.crudservlet.User;
import ru.job4j.crudservlet.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Class for user get servlet testing.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 08.11.2017.
 */
public class UserControllerTest {
    /**
     * Test.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Test
    public void addUser() throws ServletException, IOException {
        UsersAddController controller = new UsersAddController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("admin3");
        when(request.getParameter("login")).thenReturn("root3");
        when(request.getParameter("password")).thenReturn("root3");
        when(request.getParameter("email")).thenReturn("root3@root.ru");
        when(request.getParameter("role")).thenReturn("admin");

        controller.init();
        controller.doPost(request, response);
        User user = UserStorage.getInstance().getUser("root2");
        assertThat(user.getLogin(), is("root2"));
    }

    /**
     * Test.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Test
    public void editUser() throws ServletException, IOException {
        UserEditController controller = new UserEditController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("oldLogin")).thenReturn("user3");
        when(request.getParameter("name")).thenReturn("mike");
        when(request.getParameter("login")).thenReturn("mike");
        when(request.getParameter("password")).thenReturn("mike");
        when(request.getParameter("email")).thenReturn("mike@u1.ru");
        when(request.getParameter("role")).thenReturn("user");

        controller.init();
        controller.doPost(request, response);

        User user = UserStorage.getInstance().getUser("mike");
        assertThat(user.getLogin(), is("mike"));
    }

    /**
     * Test.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Test
    public void signinTest() throws ServletException, IOException {
        SigninController controller = new SigninController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("password")).thenReturn("root");

        controller.doPost(request, response);

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("password");
    }

    /**
     * Signout test.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Test
    public void singoutTest() throws ServletException, IOException {
        SignoutController controller = new SignoutController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        controller.doPost(request, response);

        verify(request, atLeast(1));
    }

    /**
     * AuthFilter test.
     * @throws IOException - exception.
     */
    @Test
    public void authFilterTest() throws IOException {
        AuthFilter filter = new AuthFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getRequestURI()).thenReturn("/items");
        when(session.getAttribute("login")).thenReturn(null);

        verify(request, atLeast(1));
    }

}
