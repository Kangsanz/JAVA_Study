<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/incl/banner.jsp">
			<jsp:param value="<%=URLEncoder.encode(\"로그인 페이지\", \"UTF-8\")%>" name="subtitle" />
		</jsp:include>
	</header>
	<form action="login" method="post">
		아이디 :
		<input type="text" name="userId" />
		<br> 비밀번호 :
		<input type="password" name="passwd" />
		<br>
		<input type="submit" name="확인" />
	</form>

	<h3>모든 유저 찾기</h3>
	<a href='<c:url value="/mod009/add_user.jsp" />'>회원가입 페이지</a>
</body>
</html>