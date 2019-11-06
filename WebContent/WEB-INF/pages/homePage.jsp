<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//September 17, 2019 
	//This is our own work. 
	
	//VIEW
	//this is the home page of the website; it will greet the user--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>RGO Crew</title>
    <link rel="stylesheet" href="/resources/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    <link rel="stylesheet" href="/resources/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/assets/fonts/line-awesome.min.css">
    <link rel="stylesheet" href="/resources/assets/css/Login-Form-Dark.css">
</head>

<body id="page-top" style="background-image: url(&quot;resources/ezgif.com-video-to-gif.gif&quot;); background-size: cover;">
    
    <div style="margin-top: 100px; position:relative">
	<c:if test ="${user.username != ''}"> 	
		<h1>Welcome to the crew, ${user.username}!</h1>
	</c:if>
	<c:if test ="${user.username == ''}"> 	
		<h1>Welcome to the site!</h1>
	</c:if>
	</div>

    <script src="/resources/assets/js/jquery.min.js"></script>
    <script src="/resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="/resources/assets/js/grayscale.js"></script>
</body>

</html>
