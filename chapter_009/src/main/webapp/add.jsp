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
<form action ="<%=request.getContextPath()%>/user/add" method="post">
    <h2><%=request.getContextPath()%></h2>
    <h3>Name:</h3>
    <input type="text" name="name"/>
    <h3>login:</h3>
    <input type="text" name = "login"/>
    <h3>email:</h3>
    <input type="text" name = "email"/></br>
    <input type = "submit" value = add">
    <a href="index.jsp">back</a>
</form>
</body>
</html>
