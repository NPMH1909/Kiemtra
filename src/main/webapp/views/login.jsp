<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Đăng nhập:</h1>
	<form action="login/user" method="post">
		<p>
			username: <input type="text" value="" name="username">
		</p>
		<p>
			password: <input type="password" value="" name="password">
		</p>
		<input type="submit" value="login">
	</form>
</body>
</html>
