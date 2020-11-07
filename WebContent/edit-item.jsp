<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coffee Bean Database</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Origin: <input type ="text" name = "origin" value="${itemToEdit.origin}" pattern="[A-Z][A-Za-z]{3,20}" title="Mexico" required>
Roast: <input type = "text" name = "roast" value= "${itemToEdit.roast}" pattern="[A-Z][A-Za-z ]{3,20}" title="Light Roast" required>
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>