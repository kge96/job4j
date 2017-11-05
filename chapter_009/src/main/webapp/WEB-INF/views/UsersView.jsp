<%@ page import="ru.job4j.crudservlet.User" %>
<%@ page import="ru.job4j.crudservlet.UserStorage" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            <c:forEach items="${users}" var="users">
        <tr>
            <td><c:out value="${users.name}"></c:out></td>
            <td><c:out value="${users.login}"></c:out></td>
            <td><c:out value="${users.email}"></c:out></td>
        </tr>
            </c:forEach>
    </table>
    </br>
    <input type="submit" value="edit">
    <input type="submit" value="delete">
    <a href="add">add user</a>
</body>
</html>
