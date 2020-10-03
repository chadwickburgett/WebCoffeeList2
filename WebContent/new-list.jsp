<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coffee Bean Program</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type ="text" name = "listName"><br />
Trip date: <input type ="text" name = "month" placeholder="mm"
size="4"> <input type ="text" name = "day" placeholder="dd"
size="4">, <input type ="text" name = "year" placeholder="yyyy"
size="4">
Shopper Name: <input type = "text" name = "shopperName"><br />
Available Beans:<br />
<select name="allBeansToAdd" multiple size="6">
<c:forEach items="${requestScope.allBeans}" var="currentitem">
	<option value = "${currentitem.id}">${currentitem.origin} | ${currentitem.roast}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Beans">
</form>
<a href = "index.html">Go add new Beans instead.</a>
</body>
</html>