<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//November 7, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the common error page that will appear with a given message when there is an error that occurs--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>

<title>Error</title>

<div class="error">
<font color="red"><p>${error}</p></font>
</div>
