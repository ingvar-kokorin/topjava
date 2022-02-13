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

<table border="3" align="center" style="border-collapse: collapse" cellspacing="5" cellpadding="5" >
    <thead>
    <tr align="center">
        <td>Date</td>
        <td>Description</td>
        <td>Calories</td>
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

        <tr style="color: ${color}">
            <td>${meal.date} ${meal.time}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>