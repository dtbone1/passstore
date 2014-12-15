<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a class="title" href="<c:url value='/'/>">PassStore</a>

<sec:authorize access="!isAuthenticated()">
	<a class="login" href="<c:url value='/login'/>">Log in</a>
</sec:authorize>
	
<sec:authorize access="isAuthenticated()">
	<a class="login" href="<c:url value='/j_spring_security_logout'/>">Log out</a>
</sec:authorize>