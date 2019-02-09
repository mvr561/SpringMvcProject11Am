<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Uom Edit Page</h2>
<f:form action="update" method="post" modelAttribute="u">

<pre>
Id:<f:input path="uomId" />



Uom Type:<f:select path="uomType">
<f:option value="">--select--</f:option>
<f:option value="PACKING">Packing</f:option>
<f:option value="NOPACKING">NoPacking</f:option>
<f:option value="NA">NA</f:option>
</f:select>
Uom Model:<f:input path="uomModel"/>
Uom Description:<f:textarea path="uomDsc"/>

<input type="submit" value="Update"/>
</pre>

</f:form>

</body>
</html>