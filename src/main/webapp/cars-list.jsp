<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Favorite Cars List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
	<table>
	<c:forEach items="${requestScope.allCars}" var="currentcar">
	<tr>
		<td><input type="radio" name="id" value="${currentcar.id}"></td>
		<td>${currentcar.year}</td>
		<td>${currentcar.make}</td>
		<td>${currentcar.model}</td>
		</tr>
	</c:forEach>
	</table>
	<input type="submit" value="Edit" name="doThisToCar">
	<input type="submit" value="Delete" name="doThisToCar">
	<input type="submit" value="Add" name="doThisToCar">
	</form>
</body>
</html>