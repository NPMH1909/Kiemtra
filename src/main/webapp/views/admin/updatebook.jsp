<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="admin-update" method ="post">
		<label>ID:</label>
		<input type = "text" name= "bookid" value="${book.bookid}" readonly="readonly">
		<label>Nhập ISBN: </label>
		<input type = "text" name= "isbn" value="${book.isbn}">
		<label>Nhập Title: </label>
		<input type = "text" name= "title" value="${book.title}">
		<label>Nhập Publisher: </label>
		<input type = "text" name= "publisher" value="${book.publisher}">
		<label>Nhập Price: </label>
		<input type = "text" name= "price" value="${book.price}">
		<label>Nhập Description: </label>
		<input type = "text" name= "description" value="${book.description}">
		<label>Nhập Cover Image: </label>
		<input type = "text" name= "cover_image" value="${book.cover_image}">
		<label>Nhập Quantity: </label>
		<input type = "text" name= "quantity" value="${book.quantity}">
		<input type ="submit" value= "update book">
	</form>
</body>
</html>