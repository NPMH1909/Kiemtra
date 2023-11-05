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
             <th>Book ID</th>
             <th>ISBN</th>
             <th>Title</th>
             <th>Publisher ID</th>
             <th>Price</th>
             <th>Description</th>
             <th>Cover Image</th>
             <th>Quantity</th>
  
             <th>Action</th>
             </tr>
        </thead>
        <c:forEach var="i" items="${listBook}">
            <tr>
                <td>${i.bookid}</td>
                <td>${i.isbn}</td>
                <td>${i.title}</td>
                <td>${i.publisher}</td>
                <td>${i.price}</td>
                <td>${i.description}</td>
                <td>${i.cover_image}</td>
                <td>${i.quantity}</td>
                
                <td><a href="admin-update?id=${i.bookid}">Update</a> || <a href="admin-delete?id=${i.bookid}"> Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    
    <div class="row">
     <div class="col-md-4 col-sm-4 items-info"></div>
     <div class="col-md-4 col-sm-4">
        <ul class="pagination pull-right">
            <c:if test="${tag>1}">
                <li><a href="${pageContext.request.contextPath}/admin-view?index=${tag-1}">&laquo;</a></li>
            </c:if>
            <c:forEach begin="1" end="${endP}" var="i"> 
                <li class='${tag==i?"active":""}' style="margin: 0 10px;"> <!-- Điều chỉnh khoảng cách ở đây -->
                    <a href="${pageContext.request.contextPath}/admin-view?index=${i}">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${tag<endP}">
                <li><a href="${pageContext.request.contextPath}/admin-view?index=${tag+1}">&raquo;</a></li>
            </c:if>
        </ul>
     </div>
</div>

    
</body>
</html>
