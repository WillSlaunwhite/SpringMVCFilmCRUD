<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${message }
	${film}<br>
	Cast: ${film.cast}
	Category: ${film.category}<br>

	<form action="delete.do" method="get">
		<p> Would you like to delete this film?</p> 
		<input type="radio" name="deleteFilm" value="yes"> <label>Yes</label>
		<input type="radio" name="deleteFilm" value="no"> <label>No</label><br> 
		<input type="text" hidden="true" name="id" value="${film.id }">
		<input type="submit" value="Submit">
	</form>
	
	<form action="edit.do" method="get">
		<p> Would you like to edit this film?</p> 
		<input type="radio" name="editFilm" value="yes"> <label>Yes</label>
		<input type="radio" name="editFilm" value="no"> <label>No</label><br> 
		<input type="text" hidden="true" name="id" value="${film.id }">
		<input type="submit" value="Submit">
	</form>
</body>
</html>