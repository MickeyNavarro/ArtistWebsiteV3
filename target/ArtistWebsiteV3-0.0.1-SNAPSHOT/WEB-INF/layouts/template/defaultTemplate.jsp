<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

<head>
<title>RGO Crew</title>
	<spring:url value="/resources/assets/bootstrap/css/bootstrap.min.css" var="mainCss" />
	<spring:url value="/resources/assets/bootstrap/js/bootstrap.min.js" var="mainJs" />

	<link href="${mainCss}" rel="stylesheet" />
	<script src="${mainJs}"></script>
</head>

<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />
	
	<!-- Body Page -->
	<div align="center">
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>
</html>