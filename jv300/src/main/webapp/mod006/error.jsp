<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<div>
		<h2>ERROR! 필수 입력 정보를 입력해주세요.</h2>
		<%
		List<String> errorMsgs = (List<String>) request.getAttribute("errorMsgs");
		out.println("<ul><h3>- 입력해야 할 정보 -</h3>");
		for (String b : errorMsgs) {
			out.println("<li>" + b + "</li><br>");
		}
		out.println("</ul>");
		%>
	</div>
</body>
</html>