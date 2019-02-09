<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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

<div class="card-header bg-primary text-white"><h2>Welcome to Uom Page</h2></div>

<div class="card-body">

<f:form cssClass="form" action="insert" method="post" modelAttribute="uom">
<div class="row">

<div class="col-2">
<label for="uomType">Uom Type:</label>

</div>
<div class="col-6">
<f:select path="uomType" cssClass="form-control">
<f:option value="">--select--</f:option>
<f:option value="PACKING">Packing</f:option>
<f:option value="NOPACKING">NoPacking</f:option>
<f:option value="NA">NA</f:option>
</f:select>
</div>
<div class="col-6">
<f:errors path="uomType"/>
</div>
</div>

<div class="row" >

<div class="col-2">
<label for="uomModel">Uom Model:</label>
</div>
<div class="col-6">
<f:input path="uomModel" cssClass="form-control"/>
</div>
</div>
<div class="col-6">
<f:errors path="uomModel" />
</div>
</div>

<div class="row" >

<div class="col-2">
<label for="uomDsc">Uom Description:</label>
</div>
<div class="col-6">
<f:textarea path="uomDsc" cssClass="form-control"/>
</div>
</div>
<div class="col-6">
<f:errors path="uomDsc" />
</div>
</div>



<input type="submit" class="btn btn-secondary" value="ClickOnUom"/>

</f:form>
</div>

<c:if test="${message != null }">
<div class="card-footer bg-warning text-white">
	${message}
</div>
</c:if>

<a href="all" class="btn btn-secondary" class="col-6">ViewAll</a>
</div> <!-- For Card Ending -->
</div>
</body>
</html>