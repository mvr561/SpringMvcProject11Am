<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="excelexp" >Excel Export</a> | <a href="pdfExp">PDFExport</a>
<%@include file="UserMenu.jsp" %>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-center">
<h2>Welcome to UserData Page</h2>
</div>

<div class="card-body">

<c:choose>
		<c:when test="${empty list }">
			<h4>No Data Found</h4>
		</c:when>
		<c:otherwise>
<table class="table table-hover table-striped" >



<tr class="table-primary">
<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>PASSWORD</th>
<th>ROLES</th>
<th>CONTACT</th>
<th colspan="7">OPERATIONS</th>

   

</tr>
<c:forEach items="${list}" var="st">

<tr>
<td><c:out value="${st.userId}"/></td>
<td><c:out value="${st.userName}"/></td>
<td><c:out value="${st.userEmail}"/></td>
<td><c:out value="${st.userPwd}"/></td>
<td><c:out value="${st.roles}"/></td>
<td><c:out value="${st.mobile}"/></td>
<td>
<a href="delete?uid=${st.userId}"><img src="../resources/images/delete.png" width="20" height="20"/></a>
</td>
<td><a href="viewone?uid=${st.userId}"><img src="../resources/images/view.png" width="20" height="20"/></a> 
</td>
<td><a href="editone?uid=${st.userId}"><img src="../resources/images/edit.png" width="20" height="20"/></a> 
</td>
<td><a href="viewoneexcel?uid=${st.userId}"><img src="../resources/images/Excel.png" width="20" height="20"/></a> 
</td>
<td><a href="pdfOneExp?uid=${st.userId}"><img src="../resources/images/pdf.png" width="20" height="20"/></a> 
</td>
</tr>
</c:forEach>

</table>
</c:otherwise>
</c:choose>
</div>
<c:if test="${message != null}">
<div class="card-footer bg-success">
${message} 
</div>
</c:if>
</div>
</div>  <!-- Container end -->
</body>
</html>