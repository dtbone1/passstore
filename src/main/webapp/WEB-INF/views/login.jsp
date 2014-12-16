<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function(){
		document.f.j_username.focus();
	});
</script>
<div class="centerText">
<h3>Login with Email Address and Password</h3>
<c:if test="${param.error != null}">
	<p class="error">Login failed. Check that your Email Address and Password are correct.</p>
</c:if>
</div>
<div class="centerLogin">
	
	<form name='f'
		action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
		<table class="formtable">
			<tr>
				<td>Email:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td>Remember Me:</td>
				<td><input type='checkbox' name='_spring_security_remember_me' checked="checked" /></td>
			</tr>
			<tr>
				<td colspan='2'><input class="myButton" name="submit" type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="<c:url value="/newaccount"/>">Create new account</a>
	</p>
</div>