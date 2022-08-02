<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
</head>

<body>
	<main>
		<div>
			<h3>카테고리 목록</h3>
			<label>Drink</label>
			<ul>
<%-- 				<c:forEach var="item" items="${bigCategoryNameList}"> --%>
<%-- 					<li><c:out value="${item}" /></li> --%>
<%-- 				</c:forEach> --%>
<!-- 			</ul> -->
<!-- 			<br> <label>Dessert</label> -->
<!-- 			<ul> -->
<%-- 				<c:forEach var="item" items="${midCategoryNameList}"> --%>
<%-- 					<li><c:out value="${item}" /></li> --%>
<%-- 				</c:forEach> --%>
			</ul>
		</div>
	</main>
</body>
</html>