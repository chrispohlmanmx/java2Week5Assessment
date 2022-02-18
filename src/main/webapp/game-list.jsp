<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Game List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allGames}" var="currentGame">
			<tr>
				<td><input type="radio" name="id" value="${currentGame.id}"></td>
				<td>${currentGame.title}</td>
				<td>${currentGame.system}</td>
			</tr>
			</c:forEach>
		</table>
		
		<input type="submit" value="edit" name="doThisToGame">
		<input type="submit" value="delete" name="doThisToGame">
		<input type="submit" value="add" name="doThisToGame">
	</form>
</body>
</html>