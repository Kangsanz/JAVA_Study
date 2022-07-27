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
			<h3>가입 성공!</h3>
			<form action="step1" method="get">
				<input type="submit" value="돌아가기">
			</form>
		</div>
	</main>
</body>
</html>