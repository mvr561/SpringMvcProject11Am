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
<h2>Welcome to Item Edit Page</h2>
<f:form action="update" method="post" modelAttribute="s">

<pre>
Id:<f:input path="itemId" readonly="true"/>

  
Item Code:  <f:input path="itemCode"/> 

Item Length:  <f:input path="itemLength"/>  

Item Width:  <f:input path="itemWidth"/>  

Item Height:  <f:input path="itemHeight"/> 

BaseCost:  <f:input path="baseCost"/>  

Base Currency:  <f:select path="baseCurrency" cssClass="form-control">
<f:option value="">---select--</f:option>
<f:option value="INR">INR</f:option>
<f:option value="USD">USD</f:option>
<f:option value="AUS">AUS</f:option>
<f:option value="ERU">ERU</f:option>
</f:select>
Item DSc:  <f:textarea path="itemDsc"/>     

 



<input type="submit" value="Update"/>
</pre>

</f:form>

</body>
</html>