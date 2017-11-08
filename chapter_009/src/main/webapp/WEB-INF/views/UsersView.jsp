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
<p>Здравствуйте <c:out value="${login}"></c:out></p>
<p>Вы вошли как <c:out value="${role}"></c:out></p>

<form action="${pageContext.servletContext.contextPath}/signout" method="post">
    <input type="submit" value="signout">
</form>
    <table style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
        <tr>
            <th>user name</th>
            <th>login</th>
            <th>e-mail</th>
            <th>role</th>
            <th>edit</th>

        </tr>
            <c:forEach items="${users}" var="users">
        <tr>
            <td><c:out value="${users.name}"></c:out></td>
            <td><c:out value="${users.login}"></c:out></td>
            <td><c:out value="${users.email}"></c:out></td>
            <td><c:out value="${users.role}"></c:out></td>

            <c:if test="${role == 'admin' || role != 'admin' && login == users.login}">
                <td>
                    <a href="edit">
                        <input type="submit" value="edit" name="<c:out value="${users.login}"></c:out>">
                    </a>
                </td>
            </c:if>
            <c:if test="${role == 'user' && login != users.login}">
                <td><a onclick="false" style="color: gray">edit</a></td>
            </c:if>
        </tr>
            </c:forEach>
    </table>
    </br>
    <c:if test="${role == 'admin'}">
        <a href="add" value="new">new</a>
    </c:if>

</body>
</html>
