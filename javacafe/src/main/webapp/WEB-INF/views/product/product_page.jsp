<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.net.URLEncoder"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="row">
	<c:forEach var="item" items="${bigCategoryListName}">
		<form class="col" action="product_page1" method="get">
			<input type="hidden" value="<c:out value="${item}" />" name="bigCategory" />
			<input type="submit" class="btn btn-dark" value="<c:out value="${item}" />" />
		</form>
	</c:forEach>
</div>
<div class="row">
	<c:forEach var="item" items="${midCategoryListName}">
		<form class="col-3 my-3" action="product_page2" method="get">
			<input type="hidden" value="<c:out value="${item}" />" name="midCategory" />
			<input type="submit" class="btn btn-secondary" value="<c:out value="${item}" />" />
		</form>
	</c:forEach>
</div>

<div class="row mb-5 vh-100">
	<c:forEach var="item" items="${categoryProducts}" varStatus="status">
		<div class="col-4">
			<form action="product_page" method="post">
				<div class="form-group mx-sm-3 mb-2">
					<img class="my-3" alt="<c:out value="${item}" />" src="<c:url value='/resources/img/${item}.jpg'/>" width="225" height="225">
					<input type="text" class="input-group-text my-3 marginAuto" name="product" value="<c:out value="${item}" />" readonly />
					<input type="hidden" value="${categoryProducts}" name="categoryProducts" />
					<input type="hidden" value="${productsPrice}" name="productsPrice" />
					<input type="hidden" value="${cartList}" name="cartList" />

					<c:forEach var="item" items="${cartList}">
						<input type="hidden" value="1" name="${item}">
					</c:forEach>

					<input type="submit" class="btn btn-primary my-3" value="추가">
				</div>
			</form>
		</div>
	</c:forEach>
</div>

<div class="row container position-fixed bottom-0 cart">
	<div class="col-8">
		<ul class="list-unstyled overflow-Y">
			<c:forEach var="item" items="${cartList}">
				<form class="row justify-content-between" action="cart_page" method="post">
					<input type="text" class="d-flex justify-content-center align-items-center text-center form-control-plaintext" name="proName" value="${item}" readonly>
					<input type="number" class="my-2 col-1" name="amount" value="1" required>
					<input type="submit" class="btn btn-dark my-2 col-1 delete" value="삭제">
				</form>
			</c:forEach>
		</ul>
	</div>
	<div class="col-4 position-fixed totalPrice">
		<form action="purchase_page" method="post">
			<label for="totalPrice">총 금액</label>
			<input type="text" class="input-group-text my-3 marginAuto" id="totalPrice" name="totalPrice" value="<c:out value="${totalPrice}" />" readonly />
			<input type="submit" class="btn btn-primary my-3" value="결제하기">
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/system_footer.jsp"%>