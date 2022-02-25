<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Game Libraries</title>
</head>
<body>
	<form method="post" action = "librarynavigationservlet">
		<table>
			<c:forEach items = "${requestScope.allLibraries }" var="currentLibrary">
				<tr>
					<td><input type = "radio" name="id" value="${currentLibrary.id}"></td>
					<td><h2>${currentLibrary.name}</h2></td>
				</tr>
				<c:forEach items = "${currentLibrary.videoGames}" var = "gameVal">
					<tr>
						<td>${gameVal.title}</td>
						<td>${gameVal.system}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value = "delete" name="doThisToList">
		<input type="submit" value = "add" name="doThisToList">
	</form>
	<a href="addLibraryServlet">Create a New Game Library</a>
	<a href="index.html">Insert a new Game</a>
</body>
</html>