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

<div class="card-header bg-success text-white">

<h2>Welcome to Order Method Register page!!</h2>

</div>

<div class="card-body">

<f:form cssClass="form" action="insert" method="post" modelAttribute="orderMethod">
<div class="row">

<div class="col-2">
<label for="orderMode">OrderMode:</label>

</div>
<div class="col-5">
<f:radiobutton path="orderMode"  value="SALE"/>Sale<br>
<f:radiobutton path="orderMode"  value="PURCHASE"/>Purchase  

</div>
<div class="col-5">
<f:errors path="orderMode" cssClass="text-danger"/>
</div>

</div>
<div class="row">

<div class="col-2">
<label for="orderDsc">Description:</label>
</div>
<div class="col-5">
<f:textarea path="orderDsc" cssClass="form-control" /> 
</div>
<div class="col-5">
<f:errors path="orderDsc" cssClass="text-danger text-center"/>
</div>
</div>
<div class="row">
<div class="col-2">
<label for="orderAccept">Order Accept:</label>
</div>
<div class="col-5">
<f:checkbox path="orderAccept"  value="Multi-Model"/>Multi-Model<br>
 <f:checkbox path="orderAccept"  value="Accept Return"/>Accept Return<br>
 <f:checkbox path="orderAccept"  value="Serevice Extend"/>Serevice Extend <br>
</div>
<div class="col-5">
 <br><f:errors path="orderAccept" cssClass="text-danger text-center"/>
</div>

</div>

<div class="row">

<div class="col-2">
<label for="orderCode">Order Code:</label>
</div>
<div class="col-5">
 <f:input path="orderCode" cssClass="form-control"/>
 
</div>
<div class="col-5">
<f:errors path="orderCode" cssClass="text-danger text-center"/>
</div>

</div>

<div class="row">

<div class="col-2">
<label for="">Execute Type:</label>
</div>
<div class="col-5">
<f:select path="exeType" cssClass="form-control">
<f:option value="">---select--</f:option>
<f:option value="FIFO">FIFO</f:option>
<f:option value="LIFO">LIFO</f:option>
<f:option value="FCFO">FCFO</f:option>
<f:option value="FEFO">FEFO</f:option>
</f:select>
<div class="col-5">
<f:errors path="exeType" cssClass="text-danger text-center"/>
</div>

</div>

</div>

   


             
<input type="submit" class="btn btn-success"  value="clickOrd"/>           

</f:form>
</div> <!-- body card end -->


<c:if test="${message != null}">
<div class="card-footer bg-primary text-white">
${message}
</div>
</c:if>
</div>
<a href="all" class="btn btn-secondary text-center" >View All</a>

</div>
</body>
</html>