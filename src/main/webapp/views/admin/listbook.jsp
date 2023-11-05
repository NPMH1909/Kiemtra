<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:if test="${message!=null}">
        <span>${message}</span>
    </c:if>
    <c:if test="${error!=null}">
        <span>${error}</span>
    </c:if>
    <a href="admin-add">Add</a>
    
    <table border="1" style="width:100%">
        <thead>
             <tr>
             <th>ID</th>
             <th>Name</th>
             <th>Icon</th>
             <th>Action</th>
             </tr>
        </thead>
        <c:forEach var="i" items="${listcate}">
            <tr>
                <td>${i.bookid}</td>
                <td>${i.title}</td>
                <td><a href="update?id=${i.bookid}">Update</a> || <a href="delete?id=${i.bookid}"> Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    
</body>
</html>
