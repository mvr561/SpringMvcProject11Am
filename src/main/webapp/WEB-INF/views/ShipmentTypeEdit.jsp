<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to ShipmentType Edit Page!!</h2>
<form:form action="update" method="post" modelAttribute="s"> 
<pre>
Id:<form:input path="id" readonly="true"/>

Shipment Mode:
<form:select path="shipmentMode">
<form:option value="">--select--</form:option>
<form:option value="AIR">Air</form:option>
<form:option value="TRUCK">Truck</form:option>
<form:option value="TRAIN">Train</form:option>
<form:option value="SHIP">Ship</form:option>
</form:select>
Shipment Code:<form:input path="shipmentCode"/>
Enable Shipment:<form:select path="enableshipment">
<form:option value="">--select</form:option>
<form:option value="YES">Yes</form:option>
<form:option value="NO">No</form:option>
</form:select>
Shipment Grade:
<form:radiobutton path="shipmentGrade" value="A"/>A
<form:radiobutton path="shipmentGrade" value="B"/>B
<form:radiobutton path="shipmentGrade" value="C"/>C
Description:<form:textarea path="shipmentDesc"/>

<input type="submit" value="Update"/>

</pre>

</form:form>

</body>
</html>