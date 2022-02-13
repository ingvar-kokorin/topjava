<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table border="2" align="center" style="border-collapse: collapse" >
    <thead>
    <tr>
        <td align="center">Date</td>
        <td align="center">Description</td>
        <td align="center">Calories</td>
    </tr>
    </thead>

    <jsp:useBean id="meals" scope="request" type="java.util.List"/>
    <c:forEach items="${meals}" var="meal">

        <c:choose>
            <c:when test="${meal.excess == true}">
                <c:set var="color" value="#FF0303FF"/>
            </c:when>
            <c:otherwise>
                <c:set var="color" value="#59981A"/>
            </c:otherwise>
        </c:choose>

        <tr>
            <td><b style="color:${color}">${meal.date} ${meal.time}</b></td>
            <td><b style="color:${color}">${meal.description}</b></td>
            <td><b style="color:${color}">${meal.calories}</b></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>