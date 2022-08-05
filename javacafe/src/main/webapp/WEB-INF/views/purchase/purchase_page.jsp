<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="row mb-5 justify-content-center">
	<div class="col-4">
		<form action="purchase_page_result" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<img class="my-3" alt="<c:out value="${proName}" />" src="<c:url value='/resources/img/${proName}.jpg'/>" width="225" height="225">
				<input type="text" class="input-group-text mt-3 marginAuto proName font-bold" name="proName" value="${proName}" readonly />
				<div class="d-flex align-items-end">
					<button type="button" class="btn btn-danger amountBtn minus">-</button>
					<input type="number" class="input-group-text mt-3 marginAuto amount font-bold" name="proAmount" value="1" max="10" required />
					<button type="button" class="btn btn-primary amountBtn plus">+</button>
				</div>
				<input type="text" class="input-group-text my-3 marginAuto font-bold" name="proPrice" value="${proPrice}" readonly />
				<input type="submit" class="btn btn-success mb-3 proBtn" value="장바구니 담기">
			</div>
		</form>
		<form action="../product/product_page" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input type="submit" class="btn btn-danger mb-3 proBtn" value="취소">
			</div>
		</form>
	</div>
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