<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="centerText">
<h2>Administrator Web Portal</h2>
</div>
<div class="center">
	<div class="CSS_Table_Example" style="width:600px;height:150px;">
	<table>
		<tr>
			 <th>Email Address</th>
			 <th>First Name</th>
			 <th>Last Name</th>
			 <th>Role</th>
		</tr>
		<c:forEach var="user" items="${users}">
		<tr>
			<td><c:out value="${user[0].email}"></c:out></td>
			<td><c:out value="${user[0].firstname}"></c:out></td>
			<td><c:out value="${user[0].lastname}"></c:out></td>
			<td><c:out value="${user[1].role}"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>