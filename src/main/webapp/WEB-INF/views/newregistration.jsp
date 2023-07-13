<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Registration</h2>
<form action="newreg" method="post">
<table>
<tr>
<td>Name</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td>City</td>
<td><input type="text" name="city"/></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email"/></td>
</tr>
<tr>
<td>Mobile</td>
<td><input type="text" name="mobile"/></td>
</tr>
<tr>
<td><input type="submit" value="save"></td>
</tr>
</table>
</form>
<%
if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
}

%>

</body>
</html>