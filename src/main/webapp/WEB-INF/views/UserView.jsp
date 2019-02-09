<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to UserView</h2>
<table border="1">
<tr>
<td>ID</td>
<td>${st.userId}</td>
</tr>

<tr>
<td>USERNAME</td>
<td>${st.userName}</td>
</tr>

<tr>
<td>EMAIL</td>
<td>${st.userEmail}</td>
</tr>

<tr>
<td>PASSWORD</td>
<td>${st.userPwd}</td>
</tr>

<tr>
<td>ROLES</td>
<td>${st.roles}</td>
</tr>

<tr>
<td>MOBILE</td>
<td>${st.mobile}</td>
</tr>
</table>
<a href="all">COMe Back</a>

</body>
</html>