<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to UserEDitpage!!</title>
<form:form action="update" method="post" modelAttribute="st">
<pre>
        Id:<form:input path="userId"/>
        
		User Name:<form:input path="userName"/>
		
		User Email<form:input path="userEmail"/>
		
		User password:<form:input path="userPwd"/>
		User roles:
		           <form:checkbox path="roles" value="admin"/>admin
				   <form:checkbox path="roles" value="appUser"/>appUser
		User mobileNo:<form:input path="mobile"/>
		<input type="submit" value="Update"/>
	</pre>



</form:form>
</head>
<body>

</body>
</html>