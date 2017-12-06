<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Car list</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width-device-width, initial-scale=1">
</head>
<body>
    <div class="container">
        <h2>Car list</h2>
        <form action="${pageContext.servletContext.contextPath}/cars.do" method="post">
            name : <input type="text" name="name"></br>
            <input type="submit" value="submit" name="button"></br>
        </form>
        <table border="1">
            <tr>
                <td>car id</td>
                <td>mark</td>
                <td>engine</td>
                <td>fuel</td>
                <td>transmission</td>
                <td>body</td>
            </tr>
            <c:forEach items="${cars}" var="car" varStatus="status">
                <tr valign="top">
                    <td>${car.id}</td>
                    <td>${car.producer.mark}</td>
                    <td>${car.engine.volume}</td>
                    <td>${car.engine.fuel.type}</td>
                    <td>${car.transmission.type}</td>
                    <td>${car.body.type}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
