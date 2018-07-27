<%-- <%@page import="kr.or.ddit.user.model.UserVo"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<%--  <a class="navbar-brand" href="#">JSP/SPRING[<%=((UserVo)session.getAttribute("userVo")).getUserId()%>]<br>
											 <!-- El: [${userVo.getUserId()}] --%>
			 
			 <a class="navbar-brand" href="/board/main.jsp">JSP/SPRING<c:if test="${studentVo.std_id !=null}">[${studentVo.std_id}]</c:if>
			</a> 
			 
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-reft">
				<li><a href="#">StudentList</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				
			</ul>
			<form class="navbar-form navbar-right">
				<li><a href="/logout">Logout</a></li>
			</form>
		</div>
	</div>
</nav>