<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param value="mod007 : Java Beans and include" name="subtitle" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h2>ERROR! 필수 입력 정보를 입력해주세요.</h2>
			<%--	
			<%
			List<String> errorMsgs = (List<String>) request.getAttribute("errorMsgs");
			out.println("<ul><h3>- 입력해야 할 정보 -</h3>");
			for (String b : errorMsgs) {
				out.println("<li>" + b + "</li><br>");
			}
			out.println("</ul>");
			%>
 --%>

			<c:if test="${not empty errorMsgs}">
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li><c:out value="${message}" /></li>
					</c:forEach>
					<c:when test="">
						<c:choose></c:choose>
						<c:otherwise></c:otherwise>
					</c:when>
				</ul>
			</c:if>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp"%>
		</div>
	</div>
</body>
</html>