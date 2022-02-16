<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="https://example.com/functions" prefix="f" %>

<html>
<head>
    <title>Add new meal</title>
</head>
<body>

<form method="POST" action='meals' name="frmAddMeal">
    Meal ID : <input type="text" readonly="readonly" name="mealId"
                     value="<c:out value="${meal.id}" />" /> <br />
    Description : <input
        type="text" name="description"
        value="<c:out value="${meal.description}" />"/> <br/>
    Calories : <input
        type="text" name="calories"
        value="<c:out value="${meal.calories}" />"/> <br/>
    DATE :<input
        type=datetime-local id="start" name="dob" value="${meal.dateTime}" />
        min="2018-01-01" max="2023-12-31"> <br/>

    <input type = "submit" value = "Submit" />
</form>

</body>
</html>