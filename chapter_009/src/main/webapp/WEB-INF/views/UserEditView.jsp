<%--
  Created by IntelliJ IDEA.
  User: g.kuznetsov
  Date: 07.11.2017
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action ="${pageContext.servletContext.contextPath}/edit" method="post">
    <c:if test="${role != 'admin'}">
        <h3>You old login:</h3>
        <input disabled readonly type="text" autocomplete="off" name = "oldLogin" value="<c:out value="${login}"></c:out>"/>
        <input type="text" autocomplete="off" name = "oldLogin" value="<c:out value="${login}"></c:out>" style="visibility: hidden"/>
    </c:if>
    <c:if test="${role == 'admin'}">
    <h3>Old login:</h3>
        <input type="text" autocomplete="off" name = "oldLogin"/>
    </c:if>

    <h3>new user name:</h3>
    <input type="text" autocomplete="off" name = "name"/>
    <h3>new login:</h3>
    <input type="text" autocomplete="off" name = "login"/>
    <h3>new password</h3>
    <input type="password" autocomplete="off" name = "password"/>
    <h3>new email:</h3>
    <input type="text" autocomplete="off" name = "email"/>

    <h3>role:</h3>
    <c:if test="${role == 'admin'}">
        <select name="role" id="role" style="width: 147px; height: 23px;">
            <c:forEach items="${roles}" var="roles">
                <option value="<c:out value="${roles}"></c:out>"><c:out value="${roles}"></c:out></option>
            </c:forEach>
        </select>
    </c:if>
    <c:if test="${role != 'admin'}">
        <input readonly disabled type="text" autocomplete="off" name = "role" value="user"/>
    </c:if>

    </br>
    </br>
    <input type = "submit" value = save">
    <a href="${pageContext.servletContext.contextPath}">back</a>
</form>
</body>
</html>
