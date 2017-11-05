<%@ page import="ru.job4j.crudservlet.User" %>
<%@ page import="ru.job4j.crudservlet.UserStorage" %>
<%--
  Created by IntelliJ IDEA.
  User: g.kuznetsov
  Date: 04.11.2017
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset=\"UTF-8\">
</head>
<body>
    <table style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
        <tr>
            <th>user name</th>
            <th>login</th>
            <th>e-mail</th>
        </tr>
            <% for (User usr : UserStorage.getInstance().getAllUsers()) {%>
        <tr>
            <td><%= usr.getName()%></td>
            <td><%= usr.getLogin()%></td>
            <td><%= usr.getEmail()%></td>
        </tr>
            <% } %>
    </table>
    </br>
    <input type="submit" value="edit">
    <input type="submit" value="delete">
    <a href="user/add">add user</a>
</body>
</html>
