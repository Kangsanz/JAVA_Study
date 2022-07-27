<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<div>
			<h3>온라인 뱅킹 가입</h3>
			<form action="add_customer" method="post">
				<label>회원ID</label>
				<input type="text" name="userId" required="required">
				<br> <label>비밀번호</label>
				<input type="password" name="passwd" required="required">
				<br> <label>이름</label>
				<input type="text" name="name" required="required">
				<br> <label>주민번호</label>
				<input type="text" name="ssn" required="required">
				<br> <label>전화번호</label>
				<input type="text" name="phone" required="required">
				<br>
				<input type="submit" value="회원가입">
			</form>
		</div>
	</main>
</body>
</html>