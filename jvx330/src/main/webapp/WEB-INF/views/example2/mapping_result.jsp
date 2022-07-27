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
	<header>
		<nav>
			<ul>
				<li><a href="#">메인</a></li>
				<li><a href="#">소개</a></li>
				<li><a href="#">상품</a></li>
				<li><a href="#">구매</a></li>
				<li><a href="#">협찬</a></li>
				<li><a href="#">정보</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<div>
			<h3>요청 매핑 어노테이션을 이용한 경로 매핑</h3>
			<h4>Result : ${result}</h4>
			<form action="" method="post">
				<input type="submit" value="확인" />
			</form>
		</div>
	</main>
</body>
</html>