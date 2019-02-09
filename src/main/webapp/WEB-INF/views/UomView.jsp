<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Uom page</h2>
<table border="1">


<tr>
<td>ID</td>
<td>${st.uomId}</td>
</tr>

<tr>
<td>TYPE</td>
<td>${st.uomType}</td>
</tr>

<tr>
<td>MODEL</td>
<td>${st.uomModel}</td>
</tr>

<tr>
<td>NOTE</td>
<td>${st.uomDsc}</td>
</tr>


</table>
<a href="all">Comeback</a>
</body>
</html>