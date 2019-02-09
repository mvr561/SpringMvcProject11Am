<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>welcome to Documents Page</h2> 
<form action="upload" method="post" enctype="multipart/form-data">
<pre>
SELECT DOCUMENT: <input type="file" placeholder="Browse" name="fileObj">
<input type="submit" value="Upload"/>


</pre>
</form>
<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>LINK</th>
	</tr>
	<f:forEach items="${list}" var="ob">
		<tr>
			<td> <f:out value="${ob[0]}"/> </td>
			<td> <f:out value="${ob[1]}"/> </td>
			<td>
				<a href="download?docId=${ob[0]}"><img src="../resources/images/down.png" width="50" height="30"/></a>
			</td>
		</tr>
	</f:forEach>
</table>
<br/>
${message}
</body>
</html>
