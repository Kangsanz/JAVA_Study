<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="banner">
	<h4><%=URLDecoder.decode(request.getParameter("subtitle"), "UTF-8")%></h4>
	<nav style="width: 450px; text-align: center; margin-bottom: 15px; border: 1px solid black;">
		<a href='<c:url value="/mod009/add_user.jsp" />' style="text-decoration: none; font-size: 20px; font-weight: bold; color: darkblue;">
			<span>회원가입 페이지</span>
		</a>
		<span> / </span>
		<a href='<c:url value="/mod010/login.jsp" />' style="text-decoration: none; font-size: 20px;  font-weight: bold; color: darkblue;">
			<span>로그인 페이지</span>
		</a>
		<span> / </span>
		<a href='<c:url value="/mod010/mypage.jsp" />' style="text-decoration: none; font-size: 20px;  font-weight: bold; color: darkblue;">
			<span>My 페이지</span>
		</a>
	</nav>
</div>