<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <nav class="navbar navbar-light navbar-expand-md navbar navbar-expand-lg fixed-top" id="mainNav">
        <div class="container"><a class="navbar-brand js-scroll-trigger" href="home" style="font-size: 26px;">rgocrew</a><button data-toggle="collapse" class="navbar-toggler navbar-toggler-right" data-target="#navbarResponsive" type="button" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation" value="Menu"><i class="fa fa-bars"></i></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item nav-link js-scroll-trigger" role="presentation"><a class="nav-link js-scroll-trigger" href="events">Events</a></li>
                    <li class="nav-item nav-link js-scroll-trigger" role="presentation"><a class="nav-link js-scroll-trigger" href="about">About</a></li>
                </ul>
            </div>
                
            <c:choose>
            <c:when test ="${sessionScope.user != null}"> 	
                <a class="js-scroll-trigger">Welcome ${user.username}<a href="logout">&nbsp; &nbsp; &nbsp;Logout&nbsp;<i class=""></i>&nbsp;</a></a>
			</c:when>
   	
   			<c:otherwise>
            <a class="js-scroll-trigger" href="login">&nbsp; &nbsp; &nbsp;Login&nbsp;<i class="fa fa-sign-in"></i>&nbsp;</a>
           	</c:otherwise>
           	</c:choose>
            </div>
    </nav>
 
