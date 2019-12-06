<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="home#" class="nav-link nav-link-ltr">HOME</a>
    <a href="home#events" class="nav-link nav-link-ltr w3-hide-small">EVENTS</a>
    <a href="home#about" class="nav-link nav-link-ltr w3-hide-small">ABOUT</a>
    <a href="home#music" class="nav-link nav-link-ltr w3-hide-small">MUSIC</a>
		<c:choose>
            <c:when test ="${sessionScope.user != null}"> 
            <a href="logout" class="nav-link nav-link-ltr w3-hide-small w3-right">LOGOUT</a>
            <a class="nav-link nav-link-ltr w3-hide-small w3-right">CREW MEMBER: ${user.username}</a>
            
            
            <c:if test="${sessionScope.user.username == 'admin'}">
            <a href="adminEvents" class="nav-link nav-link-ltr w3-hide-small">ADMIN</a>
            </c:if>
            </c:when>
   			<c:otherwise>
    <a href="login" class="nav-link nav-link-ltr w3-hide-small w3-right">LOGIN <i class="fa fa-sign-in"></i></a>
    </c:otherwise>
           	</c:choose>
  </div>
</div>

<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
  <a href="home#events" class="nav-link nav-link-ltr w3-bar-item" onclick="myFunction()">EVENTS</a>
  <a href="home#about" class="nav-link nav-link-ltr w3-bar-item" onclick="myFunction()">ABOUT</a>
  <a href="home#music" class="nav-link nav-link-ltr w3-bar-item" onclick="myFunction()">MUSIC</a>
  <hr>
  <c:choose>
            <c:when test ="${sessionScope.user != null}"> 
            <a class="nav-link nav-link-ltr w3-bar-item">CREW MEMBER: ${user.username}</a>
            <a href="logout" class="nav-link nav-link-ltr w3-bar-item">LOGOUT</a>

            <c:if test="${sessionScope.user.username == 'admin'}">
            <a href="adminEvents" class="nav-link nav-link-ltr w3-bar-item">ADMIN</a>
            </c:if>
            </c:when>
   			<c:otherwise>
    <a href="login" class="nav-link nav-link-ltr w3-bar-item">LOGIN <i class="fa fa-sign-in"></i></a>
    </c:otherwise>
           	</c:choose>
</div>

<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>
