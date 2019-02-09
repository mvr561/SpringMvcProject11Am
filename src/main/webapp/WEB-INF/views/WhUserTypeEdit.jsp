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
<h2>Welcome to WhUser Edit Page</h2>
<f:form action="update" method="post" modelAttribute="wstr">
<pre>
User Id:<f:input path="id"/>

User Type:<f:radiobutton path="userType" value="VENDOR"/>Vendor
          <f:radiobutton path="userType" value="CUSTOMER"/>Customer
User Code:<f:input path="userCode"/> 
User For:<f:select path="userFor">
     <f:option value="PURCHASE">Purchase</f:option>
      <f:option value="SALE">Sale</f:option>
        </f:select>
User Email:<f:input path="userEmail"/> 
User Contact:<f:input path="userContact"/>  
User Id Type:<f:select path="userIdType">
            <f:option value="">--select--</f:option>
            <f:option value="PANCARD">PANCARD</f:option>
            <f:option value="AADHAR">AADHAR</f:option>
            <f:option value="VOTERID">VOTERID</f:option>
            <f:option value="OTHER">OTHER</f:option>
            
             </f:select>
 If Other:<f:input path="ifOther"/>
 Id Number:<f:input path="idNo"/> 
 <input type="submit" value="Update"/>                         
</pre>

</f:form>

</body>
</html>