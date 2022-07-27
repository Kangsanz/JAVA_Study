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
			<h3>계좌 개설</h3>
			<form action="add_account" method="post">
				<label>고객ID</label>
				<input type="text" name="userId" value="${userId}" readonly="readonly">
				<br> <label>계좌종류</label>
				<select name="accType">
					<option value="none">=== 선택 ===</option>
					<option value="S">S</option>
					<option value="A">A</option>
				</select>
				<br> <label>잔액</label>
				<input type="number" name="balance" value="10000" required="required" readonly="readonly">
				<br> <label>이자율</label>
				<input type="number" name="interestRate" value="2.0" required="required" readonly="readonly">
				<br>
				<input type="submit" value="회원가입">
			</form>
		</div>
	</main>
</body>
</html>