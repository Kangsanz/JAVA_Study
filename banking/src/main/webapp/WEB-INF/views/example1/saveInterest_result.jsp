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
			<h3>고객ID로 계좌 찾기</h3>
			<form action="getAccounts" method="post">
				<label>고객ID</label>
				<input type="text" name="userId" required="required">
				<input type="submit" value="계좌 찾기">
			</form>
		</div>
	</main>
</body>
</html>