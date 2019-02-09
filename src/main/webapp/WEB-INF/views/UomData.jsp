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

<%@include file="UserMenu.jsp" %>
<div class="container">
<a href="excelexp">Excel Export</a> | <a href="pdfExp">PDFExport</a>
</div>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-center">
<h2>Welcome to UomData Page</h2>
</div>

<div class="card-body">

<c:choose>
		<c:when test="${empty list }">
			<h4>No Data Found</h4>
		</c:when>
		<c:otherwise>
<table class="table table-hover table-striped" >



<tr class="table-primary">
<th > ID</th>
<th>TYPE</th>
<th>MODEL</th>
<th>DESCRIPTION</th>
<th colspan="6" >OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="st">
<tr>
<td><c:out value="${st.uomId}"/></td>
<td><c:out value="${st.uomType}"/></td>
<td><c:out value="${st.uomModel}"/></td>
<td><c:out value="${st.uomDsc}"/></td>

<td>
<a href="delete?uid=${st.uomId}">
<img src="../resources/images/delete.png" width="20" height="20"/>
</a>
<td><a href="viewone?uid=${st.uomId}"><img src="../resources/images/view.png" width="20" height="20"/></a> 
</td>
<td><a href="editone?uid=${st.uomId}"><img src="../resources/images/edit.png" width="20" height="20"/></a> 
</td>
<td><a href="viewoneexcel?uid=${st.uomId}"><img src="../resources/images/Excel.png" width="20" height="20"/></a> 
<td><a href="pdfOneExp?uid=${st.uomId}"><img src="../resources/images/pdf.png" width="20" height="20"/></a> 
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