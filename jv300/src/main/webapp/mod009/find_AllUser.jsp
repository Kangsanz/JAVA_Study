<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param value="<%=URLEncoder.encode(\"모든 유저 찾기\", \"UTF-8\")%>" name="subtitle" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h1>회원가입 완료</h1>
			<ul>
				<span>모든 유저 : </span>
				<c:forEach var="user" items="${userList}">
					<li>${user}</li>
				</c:forEach>
			</ul>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</div>
</body>
</html>