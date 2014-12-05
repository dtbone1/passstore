<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>Results</h1>
<p/>
<div class="CSS_Table_Example" style="width:600px;height:150px;">
<table>
	<tr>
		 <th>Email Address</th>
		 <th>First Name</th>
		 <th>Last Name</th>
		 <th>Role ID</th>
	</tr>
	<c:forEach var="user" items="${users}">
	<tr>
		<td><c:out value="${user.email}"></c:out></td>
		<td><c:out value="${user.firstname}"></c:out></td>
		<td><c:out value="${user.lastname}"></c:out></td>
		<td><c:out value="${user.roleid}"></c:out></td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>