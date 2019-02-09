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
<h2>Welcome to OrderMethod Edit Page</h2>
<f:form action="update" method="post" modelAttribute="s">

<pre>
Id:<f:input path="id" readonly="true"/>

OrderMode:<f:radiobutton path="orderMode" value="SALE"/>Sale
          <f:radiobutton path="orderMode" value="PURCHASE"/>Purchase  
Order Code:  <f:input path="orderCode"/>  
Execute Type:<f:select path="exeType">
<f:option value="">---select--</f:option>
<f:option value="FIFO">FIFO</f:option>
<f:option value="LIFO">LIFO</f:option>
<f:option value="FCFO">FCFO</f:option>
<f:option value="FEFO">FEFO</f:option>
</f:select>
             
Description:<f:textarea path="orderDsc"/>  
Order Accept:<f:checkbox path="orderAccept" value="Multi-Model"/>Multi-Model
             <f:checkbox path="orderAccept" value="Accept Return"/>Accept Return
             <f:checkbox path="orderAccept" value="Serevice Extend"/>Serevice Extend






<input type="submit" value="Update"/>
</pre>

</f:form>

</body>
</html>