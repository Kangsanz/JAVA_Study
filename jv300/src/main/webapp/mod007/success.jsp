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
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param value="mod007 : Java Beans and include" name="subtitle" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h1>회원가입 완료</h1>
			<jsp:useBean id="user" class="com.varxyz.jv300.mod007.User" scope="request" />
			아이디 : <jsp:getProperty property="userId" name="user"/><br>
			이름 : <jsp:getProperty property="userName" name="user"/>
			
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
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</div>
</body>
<style>
h3 {
	color: darkblue;
	font-weight: bold;
}
</style>
</html>