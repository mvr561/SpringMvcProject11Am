<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to WhUSerView page!!!!!!!!</h2>
<table border="1">
<tr>
<td>ID</td>
<td>${w.id}</td>
</tr>

<tr>
<td>TYPE</td>
<td>${w.userType}</td>
</tr>

<tr>
<td>CODE</td>
<td>${w.userCode}</td>
</tr>

<tr>
<td>USERFOR</td>
<td>${w.userFor}</td>
</tr>

<tr>
<td>UEMAIL</td>
<td>${w.userEmail}</td>
</tr>

<tr>
<td>UCONTACT</td>
<td>${w.userContact}</td>
</tr>

<tr>
<td>UIDTYPE</td>
<td>${w.userIdType}</td>
</tr>

<tr>
<td>IFOTHER</td>
<td>${w.ifOther}</td>
</tr>

<tr>
<td>IDNUMBER</td>
<td>${w.idNo}</td>
</tr>

</table>
<br/>
<a href="all">Come Back</a>

</body>
</html>