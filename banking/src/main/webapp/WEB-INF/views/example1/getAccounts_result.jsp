<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<div>
			<h3>계좌 찾기 완료!</h3>
			<ul>
				<c:forEach var="item" items="${accountList}">
					<li><c:out value="${item}" /></li>
				</c:forEach>
			</ul>
		</div>
	</main>
</body>
</html>