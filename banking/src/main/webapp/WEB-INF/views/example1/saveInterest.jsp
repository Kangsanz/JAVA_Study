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
			<h3>계좌 이자 지급</h3>
			<form action="saveInterest" method="post">
				<label>계좌번호</label>
				<c:forEach var="item" items="${accountNum}">
					<input type="checkbox" value="<c:out value="${item}" />">
					<c:out value="${item}" />
				</c:forEach>
				<input id="interest" type="text" value="" placeholder="이자율">
				<input type="submit" value="이자 지급">
			</form>
		</div>
	</main>
	<script>
		function myFunction(str) {
			document.getElementById("interest").value = str;
		}
	</script>
</body>
</html>