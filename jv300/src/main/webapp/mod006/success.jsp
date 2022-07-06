<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<%
	String userId = (String) request.getAttribute("userId");
	String passwd = (String) request.getAttribute("passwd");
	String userName = (String) request.getAttribute("userName");
	String ssn = (String) request.getAttribute("ssn");
	String email = (String) request.getAttribute("email");
	String addr = (String) request.getAttribute("addr");
	%>
	<h1>회원가입 완료</h1>
	<ul>
		<li>
			<h3>당신의 아이디 :</h3> <%=userId%>
		</li>
		<li>
			<h3>당신의 비밀번호 :</h3> <%=passwd%>
		</li>
		<li>
			<h3>당신의 이름 :</h3> <%=userName%>
		</li>
		<li>
			<h3>당신의 주민등록번호 앞자리 :</h3> <%=ssn%>
		</li>
		<li>
			<h3>당신의 이메일 :</h3> <%=email%>
		</li>
		<li>
			<h3>당신의 주소 :</h3> <%=addr%>
		</li>
	</ul>
</body>
<style>
h3 {
	color: darkblue;
	font-weight: bold;
}
</style>
</html>