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
<h2>Welcome to WhUserTypeRegister Page!!!!!</h2>
</div>

<div class="card-body">
<f:form action="insert" method="post" modelAttribute="whUserType">

<div class="row">

<div class="col-2">

<label for="userType">User Type:</label>
</div>

<div class="col-4">
<f:radiobutton path="userType" value="VENDOR"/>Vendor
<f:radiobutton path="userType" value="CUSTOMER"/>Customer
</div>

<div class="col-6">
<f:errors  path="userType"/>
</div>

</div>

<div class="row">

<div class="col-2">

<label for="User Code">User Code</label>
</div>

<div class="col-4">
<f:input path="userCode" cssClass="form-control"/> 
</div>

<div class="col-6">
<f:errors  path="userCode"/>
</div>
</div>

<div class="row">

<div class="col-2">

<label for="">User For</label>
</div>

<div class="col-4">
<f:select path="userFor" cssClass="form-control">
 <f:option value="PURCHASE">Purchase</f:option>
 <f:option value="SALE">Sale</f:option>
 </f:select>
</div>
<div class="col-6">
<f:errors  path="userFor"/>
</div>
</div>

<div class="row">

<div class="col-2">

<label for="">User Email</label>
</div>

<div class="col-4">
<f:input path="userEmail" cssClass="form-control"/> 
</div>
<div class="col-6">
<f:errors  path="userEmail"/>
</div>
</div>

<div class="row">

<div class="col-2">

<label for="">User Contact</label>
</div>

<div class="col-4">
<f:input path="userContact" cssClass="form-control"/> 
</div>
<div class="col-6">
<f:errors  path="userContact"/>
</div>
</div>

<div class="row">

<div class="col-2">

<label for="">User Id Type</label>
</div>

<div class="col-4">
 <f:select path="userIdType"  cssClass="form-control">
 <f:option value="">--select--</f:option>
 <f:option value="PANCARD">PANCARD</f:option>
  <f:option value="AADHAR">AADHAR</f:option>
  <f:option value="VOTERID">VOTERID</f:option>
<f:option value="OTHER">OTHER</f:option>
     </f:select>
</div>
<div class="col-6">
<f:errors  path="userIdType"/>
</div>
</div>

<div class="row">

<div class="col-2">

<label for="">If Other</label>
</div>

<div class="col-4">
<f:input path="ifOther" cssClass="form-control"/>
</div>
<div class="col-6">
<f:errors  path="ifOther"/>
</div>
</div>

<div class="row">

<div class="col-2">

<label for="">Id Number</label>
</div>

<div class="col-4">
<f:input path="idNo" cssClass="form-control"/> 
</div>
<div class="col-6">
<f:errors  path="idNo"/>
</div>
</div>

 <input type="submit" class="btn btn-success"  value="CLICK"/>                        
</f:form>
</div><!-- Card Body ends -->
<c:if test="${message != null }">
<div class="card-footer bg-primary text-white">
	${message}
</div>
</c:if>
<a href="all" class="btn btn-warning">View All</a>
</div><!-- Card close -->
</div>
</body>
</html>