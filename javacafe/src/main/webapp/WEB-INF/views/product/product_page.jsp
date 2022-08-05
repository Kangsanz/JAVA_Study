<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="row">
	<c:forEach var="item" items="${bigCategoryListName}">
		<form class="col" action="product_page1" method="get">
			<input type="hidden" value="<c:out value="${item}" />" name="bigCategory" />
			<input type="submit" class="btn btn-dark" value="<c:out value="${item}" />" />
		</form>
	</c:forEach>
</div>
<div class="row justify-content-center">
	<c:forEach var="item" items="${midCategoryListName}">
		<form class="col-2 my-3" action="product_page2" method="get">
			<input type="hidden" value="<c:out value="${item}" />" name="midCategory" />
			<input type="submit" class="btn btn-secondary" value="<c:out value="${item}" />" />
		</form>
	</c:forEach>
</div>

<div class="row mb-5 vh-100">
	<c:forEach var="item" items="${categoryProducts}" varStatus="status">
		<div class="col-4">
			<form action="../purchase/purchase_page" method="post">
				<div class="form-group mx-sm-3 mb-2">
					<img class="my-3" alt="<c:out value="${item}" />" src="<c:url value='/resources/img/${item}.jpg'/>" width="225" height="225">
					<input type="text" class="input-group-text mt-3 marginAuto proName font-bold" name="proName" value="<c:out value="${item}" />" readonly />
					<input type="text" class="input-group-text my-3 marginAuto font-bold" name="proPrice" value="${productsPrice[status.index]}원" readonly />
					<input type="submit" class="btn btn-success mb-3 proBtn" value="선택">
				</div>
			</form>
		</div>
	</c:forEach>
</div>

<div class="row container position-fixed bottom-0 cart">
	<div class="col-8">
		<ul class="list-unstyled overflow-Y">
			<c:forEach var="item" items="${cartItemList}">
				<li>
					<div class="d-flex">
						<input type="text" class="input-group-text mt-3 marginAuto proName font-bold" name="cartName" value="${fn:split(item,'/')[0]}" readonly />
						<input type="text" class="input-group-text mt-3 marginAuto proAmount font-bold" name="cartAmount" value="${fn:split(item,'/')[1]}개" readonly />
						<input type="text" class="input-group-text mt-3 marginAuto proAmount font-bold" name="cartPrice" value="${fn:split(item,'/')[2]}" readonly />
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="col-4 position-fixed totalPrice">
			<label for="totalPrice">총 금액</label>
			<input type="text" class="input-group-text my-3 marginAuto" id="totalPrice" name="totalPrice" value="${totalPrice}" readonly />
	</div>
</div>

<%@ include file="/WEB-INF/views/common/system_footer.jsp"%>