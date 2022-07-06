<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param value="<%=URLEncoder.encode(\"mod009 : Java Beans and include 한글 테스트\", \"UTF-8\")%>" name="subtitle" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h1>회원가입 완료</h1>
			<ul>
				<li><span>아이디 : </span><c:out value="${userId}" /></li>
				<li><span>비밀번호 : </span><c:out value="${passwd}" /></li>
				<li><span>이름 : </span><c:out value="${userName}" /></li>
				<li><span>주민등록번호 앞자리 : </span><c:out value="${ssn}" /></li>
				<li><span>이메일 : </span><c:out value="${email}" /></li>
				<li><span>주소 : </span><c:out value="${addr}" /></li>
			</ul>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</div>
</body>
<style>
ul,li {
	list-style: none;
	margin: 0;
	padding: 10px 0 10px 0;
}
</style>
</html>