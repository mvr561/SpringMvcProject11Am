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
<div class="container">
<a href="excelexp">Excel Export</a> | <a href="pdfExp">PDFExport</a>


<%@include file="UserMenu.jsp" %>

<div class="card">
<div class="card-header bg-primary text-center text-white">
<h2>Welcome to ItemData Page</h2>
</div>

<div class="card-body">

<c:choose>
		<c:when test="${empty list }">
			<h4>No Data Found</h4>
		</c:when>
		<c:otherwise>
<table class="table table-hover table-striped" >



<tr class="table-primary">
   <th>ID</th>
   <th>CODE</th>
   <th>LENGTH</th>
   <th>WIDTH</th>
   <th>HEIGHT</th>
   <th>COST</th>
   <th>COUNTRY</th>
   <th>DSC</th>
   <th colspan="7">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="st">

<tr>
<td><c:out value="${st.itemId}"/></td>
<td><c:out value="${st.itemCode}"/></td>
<td><c:out value="${st.itemLength}"/></td>
<td><c:out value="${st.itemWidth}"/></td>
<td><c:out value="${st.itemHeight}"/></td>
<td><c:out value="${st.baseCost}"/></td>
<td><c:out value="${st.baseCurrency}"/></td>
<td><c:out value="${st.itemDsc}"/></td>
<td>
<a href="delete?id=${st.itemId}"><img src="../resources/images/delete.png" width="20" height="20"/></a>
</td>
<td><a href="viewone?id=${st.itemId}"><img src="../resources/images/view.png" width="20" height="20"/></a></td>

<td><a href="editone?id=${st.itemId}"><img src="../resources/images/edit.png" width="20" height="20"/></a></td> 
<td><a href="viewoneexcel?id=${st.itemId}"><img src="../resources/images/Excel.png" width="20" height="20"/></a></td> 
<td><a href="pdfoneexport?id=${st.itemId}"><img src="../resources/images/pdf.png" width="20" height="20"/></a></td> 

</tr>
</c:forEach>

</table>
</c:otherwise>
</c:choose>
</div>
<c:if test="${msg != null}">
<div class="card-footer bg-success">
${msg} 
</div>
</c:if>
</div>
</div>  <!-- Container end -->
</body>
</html>