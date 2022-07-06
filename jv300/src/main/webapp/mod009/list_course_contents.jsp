<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>
		<div id="content-wrapper">
			<form action="list_course_contents.do" method="get">
				<c:forEach var="contents" items="${contentList}">
					<div>
						<c:forEach var="content" items="${contents}">
							${content}
						</c:forEach>
					</div>
				</c:forEach>
				<button type="submit">확인</button>
			</form>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>