<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="centerText">
<h2>Your Keychains</h2>
</div>
<div class="centerKeychains">
	<div class="CSS_Table_Example" style="width:900px;height:300px;">
	<table>
		<tr>
			 <th>Field 1</th>
			 <th>Field 2</th>
			 <th>Field 3</th>
			 <th>Field 4</th>
			 <th>Store Type</th>
			 <th>User Email</th>
		</tr>
		<c:forEach var="keychain" items="${keychains}">
		<tr>
			<td><c:out value="${keychain[0].encrypt1}"></c:out></td>
			<td><c:out value="${keychain[0].encrypt2}"></c:out></td>
			<td><c:out value="${keychain[0].encrypt3}"></c:out></td>
			<td><c:out value="${keychain[0].encrypt4}"></c:out></td>
			<td><c:out value="${keychain[1].type}"></c:out></td>
			<td><c:out value="${keychain[0].email}"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>