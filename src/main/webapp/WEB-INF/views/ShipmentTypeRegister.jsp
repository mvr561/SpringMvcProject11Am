<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<%@include file="UserMenu.jsp" %>
<div class="card">

<div class="card-header bg-success text-white">
<h2>Welcome to Shipment page Registration</h2>
</div>
<div class="card-body">
<form:form cssClass="form" action="insert" method="post" modelAttribute="shipmentType">

<div class="row">
<div class="col-2">
<label for="shipmentMode">Shipment Mode:</label>
</div>
<div class="col-4">
<form:select path="shipmentMode" cssClass="form-control">
<form:option value="">--select--</form:option>
<form:option value="AIR">Air</form:option>
<form:option value="TRUCK">Truck</form:option>
<form:option value="TRAIN">Train</form:option>
<form:option value="SHIP">Ship</form:option>
</form:select>
<div class="col-6">
<form:errors path="shipmentMode"/>
</div>
</div>

</div>

<div class="row">
<div class="col-2">
<label for="shipmentCode">Shipment Code:</label>
</div>
<div class="col-4">
<form:input path="shipmentCode" cssClass="form-control"/>
</div>
<div class="col-6">
<form:errors path="shipmentCode"/>
</div>
</div>

<div class="row">
<div class="col-2">
<label for="enableshipment">Enable Shipment:</label>
</div>
<div class="col-4">
<form:select path="enableshipment" cssClass="form-control">
<form:option value="">--select</form:option>
<form:option value="YES">Yes</form:option>
<form:option value="NO">No</form:option>
</form:select>
</div>
<div class="col-6">
<form:errors path="enableshipment"/>
</div>

</div>

<div class="row">
<div class="col-2">
<label for="shipmentGrade">Shipment Grade:</label>
</div>
<div class="col-4">
<form:radiobutton path="shipmentGrade" value="A"/>A<br>
<form:radiobutton path="shipmentGrade" value="B"/>B<br>
<form:radiobutton path="shipmentGrade" value="C"/>C<br>
</div>
<div class="col-6">
<form:errors path="shipmentGrade"/>
</div>
</div>

<div class="row">
<div class="col-2">
<label for="shipmentDesc">Description:</label>
</div>
<div class="col-4">
<form:textarea path="shipmentDesc" cssClass="form-control"/>
</div>
<div class="col-6">
<form:errors path="shipmentDesc"/>
</div>
</div>


<input type="submit" class="btn btn-info" value="Click on"/>


</form:form>
</div><!-- CArd body ends -->
<c:if test="${message != null }">
<div class="card-footer bg-warning text-white">
	${message}
</div>
</c:if>
</div><!-- CARD END -->
<a href="all" class="btn btn-danger">View All</a>
</div><!-- CONTAINER END -->
</body>
</html>