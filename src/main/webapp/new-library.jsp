<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Game Library</title>
</head>
<body>
	<form action="createNewLibraryServlet" method="post">
		Library Name: <input type="text" name="name"><br/>
		Available Games: <br/>
		<select name="allGamesToAdd" multiple size="5">
			<c:forEach items="${requestScope.allGames}" var = "currentGame">
				<option value="${currentGame.id}">${currentGame.title } | ${currentGame.system}</option>
			</c:forEach>
		</select>
		<br/>
		<input type="submit" value="Create Library">
	</form>
	<a href = "index.html">Add new Games</a>
</body>
</html>