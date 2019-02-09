<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="excelexp">Excel Export</a> | <a href="pdfExp">PDFExport</a>
<%@include file="UserMenu.jsp" %>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-center">
<h2>Welcome to WhuserType Page</h2>
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
<th>TYPE</th>
<th>CODE</th>
<th>USERFOR</th>
<th>UEMAIL</th>
<th>UCONTACT</th>
<th>UIDTYPE</th>
<th>IFOTHER</th>
<th>IDNUMBER</th>
<th colspan="9">OPERATIONS</th>  

</tr>
<c:forEach items="${list}" var="w">

<tr>
<td><c:out value="${w.id}"/></td>
<td><c:out value="${w.userType}"/></td>
<td><c:out value="${w.userCode}"/></td>
<td><c:out value="${w.userFor}"/></td>
<td><c:out value="${w.userEmail}"/></td>
<td><c:out value="${w.userContact}"/></td>
<td><c:out value="${w.userIdType}"/></td>
<td><c:out value="${w.ifOther}"/></td>
<td><c:out value="${w.idNo}"/></td>
<td><a href="delete?id=${w.id}"><img src="../resources/images/delete.png" width="20" height="20"/></a></td>
<td><a href="view?id=${w.id}"><img src="../resources/images/view.png" width="20" height="20"/></a></td>
<td><a href="edit?id=${w.id}"><img src="../resources/images/edit.png" width="20" height="20"/></a></td>
<td><a href="viewoneexcel?id=${w.id}"><img src="../resources/images/Excel.png" width="20" height="20"/></a></td>
<td><a href="pdfOneExp?id=${w.id}"><img src="../resources/images/pdf.png" width="20" height="20"/></a></td>
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