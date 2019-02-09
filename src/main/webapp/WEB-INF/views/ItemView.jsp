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
<td>${st.itemId}</td>
</tr>

<tr>
<td>CODE</td>
<td>${st.itemCode}</td>
</tr>

<tr>
<td>LENGTH</td>
<td>${st.itemLength}</td>
</tr>

<tr>
<td>WIDTH</td>
<td>${st.itemWidth}</td>
</tr>

<tr>
<td>Height</td>
<td>${st.itemHeight}</td>
</tr>

<tr>
<td>COST</td>
<td>${st.baseCost}</td>
</tr>

<tr>
<td>CURRENCY</td>
<td>${st.baseCurrency}</td>
</tr>

<tr>
<td>DESCRIPTON</td>
<td>${st.itemDsc}</td>
</tr>

</table>
<a href="all">Comeback</a>
</body>
</html>