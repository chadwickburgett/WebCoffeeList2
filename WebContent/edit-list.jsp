<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing List</title>
</head>
<body>
<form action = "editListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
List Name: <input type ="text" name = "listName" value="${listToEdit.listName}" pattern="[A-Z][A-Za-z' ]{3,20}" title="Kathy's List" required><br />
Trip date: <input type ="number" name = "month" placeholder="mm" size="4" value= "${month}" min="1" max="12" title="1-12" required>
 <input type ="number" name = "day" placeholder="dd" size="4" value= "${date}"  min="1" max="31" title="1-31" required>,
 <input type ="number" name= "year" placeholder="yyyy" size="4" value= "${year}"  min="2020" max="2025" title="2020-2025" required>
Shopper Name: <input type = "text" name = "shopperName" value="${listToEdit.shopper.shopperName}"  pattern="[A-Z][A-Za-z]{2,20}" title="Kathy" required><br />
Available Beans:<br />
<select name="allBeansToAdd" multiple size="6">
<c:forEach items="${requestScope.allBeans}" var="currentitem">
<option value = "${currentitem.id}">${currentitem.origin} | ${currentitem.roast}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Beans">
</form>
<a href = "index.html">Go add new Beans instead.</a>
</body>
</html>