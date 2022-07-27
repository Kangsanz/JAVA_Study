<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking System</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
</head>
<body>
	<header>
		<h3>Banking System</h3>
	</header>
	<main>
		<ul>
			<li><a href="add_customer">고객 회원가입</a></li>
			<li><a href="add_account">신규 계좌 신청</a></li>
			<li><a href="getAccounts">계좌 목록 확인</a></li>
			<li><a href="transfer">계좌 이체</a></li>
			<li><a href="add_account">계좌 이자</a></li>
			<li><a href="getBalance">계좌 잔고 확인</a></li>
		</ul>
	</main>
</body>
</html>