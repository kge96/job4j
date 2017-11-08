<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: g.kuznetsov
  Date: 04.11.2017
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action ="${pageContext.servletContext.contextPath}/add" method="post">
    <h3>user name:</h3>
    <input type="text" autocomplete="off" name = "name"/>
    <h3>login:</h3>
    <input type="text" autocomplete="off" name = "login"/>
    <h3>password</h3>
    <input type="password" autocomplete="off" name = "password">
    <h3>email:</h3>
    <input type="text" autocomplete="off" name = "email"/></br>

    <c:if test="${role == 'admin'}">
    <h3>role:</h3>
    <select name="role" id="role" style="width: 147px; height: 23px;">
        <c:forEach items="${roles}" var="roles">
            <option value="user"><c:out value="${roles}"></c:out></option>
        </c:forEach>
    </select>
    </c:if>

    </br>
    <input type = "submit" value = add">
    <a href="${pageContext.servletContext.contextPath}">back</a>
</form>
</body>
</html>
