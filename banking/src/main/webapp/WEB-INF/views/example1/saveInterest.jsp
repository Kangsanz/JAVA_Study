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
			<h3>계좌 이자 지급</h3>
			<form action="getAccounts" method="post">
				<label>계좌를 입력해주세요.</label>
				<input type="text" name="userId" required="required">
				<input type="submit" value="계좌 찾기">
			</form>
		</div>
	</main>
</body>
</html>