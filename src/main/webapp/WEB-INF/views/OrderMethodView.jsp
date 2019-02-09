<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to OrderMethod view page</h2>
<table border="1">
<tr>
<td>ID</td>
<td>${st.id}</td>
</tr>

<tr>
<td>MODE</td>
<td>${st.orderMode}</td>
</tr>

<tr>
<td>CODE</td>
<td>${st.orderCode}</td>
</tr>

<tr>
<td>TYPE</td>
<td>${st.exeType}</td>
</tr>

<tr>
<td>DESCRIPTON</td>
<td>${st.orderDsc}</td>
</tr>

<tr>
<td>ACCEPT</td>
<td>${st.orderAccept}</td>
</tr>

</table>
<a href="all">Comeback</a>
</body>
</html>