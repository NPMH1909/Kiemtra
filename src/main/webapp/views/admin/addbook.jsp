<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="admin-add" method ="post">
		<label>Nhập ISBN: </label>
		<input type = "text" name= "isbn" >
		<label>Nhập Title: </label>
		<input type = "text" name= "title" >
		<label>Nhập Publisher: </label>
		<input type = "text" name= "publisher">
		<label>Nhập Price: </label>
		<input type = "text" name= "price" >
		<label>Nhập Description: </label>
		<input type = "text" name= "description">
		<label>Nhập Cover Image: </label>
		<input type = "text" name= "cover_image">
		<label>Nhập Quantity: </label>
		<input type = "text" name= "quantity">
		<input type ="submit" value= "Insert">
	</form>
</body>
</html>