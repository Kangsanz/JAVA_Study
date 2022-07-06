<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- %@는 디렉티브 태그 --%>
<%!private static final String DEFAULT_NAME = "World";%>
<%-- %!는 멤버 변수 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- JSP 주석 --%>
<body>
	<%
	String name = request.getParameter("userName");
	if (name == null || name.length() == 0) {
		name = DEFAULT_NAME;
	}
	%><%-- 자바 코드 입력 가능 --%>
	<h3>
		Hello,
		<%=name%><%-- %=는 자바 코드 출력 --%>
	</h3>
</body>
</html>