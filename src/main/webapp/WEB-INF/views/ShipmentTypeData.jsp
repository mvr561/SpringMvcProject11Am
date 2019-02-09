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
<h2>Welcome to ShipmentType Page</h2>
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
   <th>MODE</th>
   <th>CODE</th>
  <!--  <th>ENABLE</th>
   <th>GRADE</th>
   <th>NOTE</th> -->
   <th colspan="7">OPERATIONS</th>

</tr>
<c:forEach items="${list}" var="st">

<tr>
<td><c:out value="${st.id}"/></td>
<td><c:out value="${st.shipmentMode}"/></td>
<td><c:out value="${st.shipmentCode}"/></td>
<%-- <td><c:out value="${st.enableshipment}"/></td>
<td><c:out value="${st.shipmentGrade}"/></td>
<td><c:out value="${st.shipmentDesc}"/></td> --%>
<td>
<a href="delete?sid=${st.id}"><img src="../resources/images/delete.png" width="20" height="20"/></a></td>
<td><a href="viewone?sid=${st.id}"><img src="../resources/images/view.png" width="20" height="20"/></a> 
</td>
<td>
<a href="editone?sid=${st.id}"><img src="../resources/images/edit.png" width="20" height="20"/></a>
</td>
<td>
<a href="viewoneexel?sid=${st.id}"><img src="../resources/images/Excel.png" width="20" height="20"/></a>
</td>
<td>
<a href="pdfOneExp?sid=${st.id}"><img src="../resources/images/pdf.png" width="20" height="20"/></a>
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