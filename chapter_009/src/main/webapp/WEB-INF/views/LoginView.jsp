<%--
  Created by IntelliJ IDEA.
  User: g.kuznetsov
  Date: 07.11.2017
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/signin" method="post">
        Login: <input type="text" name="login"></br></br>
        Password: <input type="password" name="password"></br></br>
        <input type="submit" name="signin" value="signin">
    </form>
    <c:if test="${error != ''}">
        <div style="color: darkred; font-size: 26px; display: block; margin: 0 auto;">
            <c:out value="${error}"/>
        </div>
    </c:if>

</body>
</html>
