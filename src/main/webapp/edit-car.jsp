<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>
</head>
<body>
	<form action="editCarServlet" method="post">
	Year: <input type="text" name="year" value="${carToEdit.year}">
	Make: <input type="text" name="make" value="${carToEdit.make}">
	Model: <input type="text" name="model" value="${carToEdit.model}">
	<input type="hidden" name="id" value="${carToEdit.id}">
	<input type="submit" value="Save Edited Car">
	</form>
</body>
</html>