<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 개설 완료</title>
</head>
<body>
	<main>
		<div>
			<h3>계좌 개설 완료!</h3>
			<ul>
				<!-- 프로퍼티 명이기 때문에 get이 필요 없음 -->
				<li>계좌번호 : ${accountNum}</li>
				<li>계좌종류 : ${accType}</li>
				<li>잔액 : ${balance}</li>
				<li>이자율 : ${interestRate}</li>
			</ul>
		</div>
	</main>
</body>
</html>