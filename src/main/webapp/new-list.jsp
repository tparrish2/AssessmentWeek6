<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
  <form action = "createNewListServlet" method="post">
  List Name: <input type ="text" name = "carListName"><br />
  Shopper Name: <input type = "text" name = "carShopperName"><br />
  Available Items:<br />
  <select name="allCarsToAdd" multiple size="6">
  <c:forEach items="${requestScope.allItems}" var="currentitem">
    <option value = "${currentitem.id}">${currentitem.year} | ${currentitem.make} | ${currentitem.model}</option>
  </c:forEach>
  </select>
  <br />
  <input type = "submit" value="Create List and Add Cars">
  </form>
  <a href = "index.html">Go add new cars instead.</a>
</body>
</html>