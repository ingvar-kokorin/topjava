<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="https://example.com/functions" prefix="f" %>

<html lang="ru">
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table border="3" align="center" style="border-collapse: collapse" cellspacing="5" cellpadding="5">
    <thead>
    <tr align="center">
        <th>Id</th>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th colspan=2>Action</th>
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
            <td>${meal.id}</td>
            <td>${f:formatLocalDateTime(meal.dateTime, 'dd.MM.yyyy HH:mm')}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=edit&mealId=<c:out value="${meal.id}"/>">Update</a></td>
            <td><a href="meals?action=delete&mealId=<c:out value="${meal.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>

</table>
<p><a href="meals?action=insert">Add User</a></p>
</body>
</html>