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
    <table border="1" style="width:100%">
        <thead>
             <tr>
             <th>ID</th>
             <th>Name</th>
             <th>Icon</th>
             <th>Action</th>
             </tr>
        </thead>
        <c:forEach var="i" items="${listBook}">
            <tr>
                <td>${i.bookid}</td>
                <td>${i.title}</td>
                
            </tr>
        </c:forEach>
    </table>
    <br>
    
    <div class="row">
     <div class="col-md-4 col-sm-4 items-info"></div>
     <div class="col-md-4 col-sm-4">
        <ul class="pagination pull-right">
            <c:if test="${tag>1}">
                <li><a href="${pageContext.request.contextPath}/view?index=${tag-1}">&laquo;</a></li>
            </c:if>
            <c:forEach begin="1" end="${endP}" var="i"> 
                <li class='${tag==i?"active":""}' style="margin: 0 10px;"> <!-- Điều chỉnh khoảng cách ở đây -->
                    <a href="${pageContext.request.contextPath}/view?index=${i}">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${tag<endP}">
                <li><a href="${pageContext.request.contextPath}/view?index=${tag+1}">&raquo;</a></li>
            </c:if>
        </ul>
     </div>
</div>

    
</body>
</html>
