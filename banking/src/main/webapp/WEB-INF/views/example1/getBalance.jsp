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
			<h3>계좌번호로 계좌 잔고 확인</h3>
			<form action="getBalance" method="post">
				<label>계좌번호</label>
				<select name="accountNum" required="required">
					<c:forEach var="item" items="${accountNum}">
						<option value="<c:out value="${item}" />"><c:out value="${item}" /></option>
					</c:forEach>
				</select>
				<input type="submit" value="잔고 확인">
			</form>
		</div>
	</main>
</body>
</html>