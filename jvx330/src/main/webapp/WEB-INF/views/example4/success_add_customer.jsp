<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
</head>
<body>
	<main>
		<div>
			<h3>회원가입 성공!</h3>
			<ul>
				<!-- 프로퍼티 명이기 때문에 get이 필요 없음 -->
				<li>이메일 : ${customerCommand.email}</li>
				<li>비밀번호 : ${customerCommand.passwd}</li>
				<li>이름 : ${customerCommand.name}</li>
				<li>주민번호 : ${customerCommand.ssn}</li>
				<li>연락처 : ${customerCommand.phone}</li>
			</ul>
		</div>
	</main>
</body>
</html>