<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>Welcome to Purchase Order Data Page!!</h2>
			</div>
			<br> <br> <br>
			<div class="card-body">
				<c:choose>
					<c:when test="${empty purchase}">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table table-hover table-bordered">

							<tr class="thead-light">
								<th>ID</th>
								<th>CODE</th>
								<th>MODE</th>
								<th>VENDOR</th>
								<th>REF NUM</th>
								<th>QC</th>
								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${purchase}" var="po">
								<tr>
									<td><c:out value="${po.orderId}"></c:out></td>
									<td><c:out value="${po.orderCode}"></c:out></td>
									<td><c:out value="${po.shipmentMode}"></c:out></td>
									<td><c:out value="${po.vendor}"></c:out></td>
									<td><c:out value="${po.refNumber}"></c:out></td>
									<td><c:out value="${po.quaCheck}"></c:out></td>
									<td><a href="viewOne?orderId=${po.orderId}"> <img
											src="../resources/images/view.jpg" height="20" width="40">
									</a></td>
									<td><a href="edit?orderId=${po.orderId}"> <img
											src="../resources/images/edit.jpg" height="20" width="40">
									</a></td>
									<td><a href="delete?orderId=${po.orderId}"> <img
											src="../resources/images/delete.png" height="20" width="40">
									</a></td>
									<td><a href="excelExport?orderId=${po.orderId }">
											<img src="../resources/images/excel.png" height="20"
											width="40" />
									</a></td>
									<td><a href="pdfExport?orderId=${po.orderId}"> <img
											src="../resources/images/pdf.png" height="20" width="40" />
									</a></td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<h6>
							to down load as excel file <a href="excelExport">click</a> here!
							<br> to down load as pdf file <a href="pdfExport">click</a>
							here!
						</h6>
					</c:otherwise>
				</c:choose>
			</div>

			<c:if test="${message !=null}">
				<div class="card-footer">${message}</div>
			</c:if>
		</div>
	</div>
	<br>
</body>
</html>