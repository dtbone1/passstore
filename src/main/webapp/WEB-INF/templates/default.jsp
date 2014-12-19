<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<tiles:useAttribute id="list" name="cssList" classname="java.util.List"/>  
<c:forEach var="cssItem" items="${list}"> 
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/${cssItem}" />
</c:forEach>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/script/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/jquery-ui.js"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>

<tiles:insertAttribute name="includes"></tiles:insertAttribute>

</head>
<body>
	<table class="centerPage">
		<tr>
			<td class="header" colspan="2"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td class="toolbar" colspan="2"><tiles:insertAttribute name="toolbar" /></td>
		</tr>
		<tr>
			<td class="footer" colspan="2"><hr/></td>
		</tr>
		<tr>
			<td class="menu"><tiles:insertAttribute name="menu" /></td>
			<td class="content"><tiles:insertAttribute name="content" /></td>
		</tr>
		<tr>
			<td class="footer" colspan="2"><hr/></td>
		</tr>
		<tr>
			<td class="footer" colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>