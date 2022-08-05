<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="row mb-5  justify-content-center">
	<div class="col-10">
		<form action="../product/product_page" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<c:forEach var="item" items="${cartItemList}">
					<div class="d-flex">
						<input type="text" class="input-group-text mt-3 marginAuto proName font-bold" name="cartName" value="${fn:split(item,'/')[0]}" readonly />
						<input type="text" class="input-group-text mt-3 marginAuto proAmount font-bold" name="cartAmount" value="${fn:split(item,'/')[1]}개" readonly />
						<input type="text" class="input-group-text mt-3 marginAuto proAmount font-bold" name="cartPrice" value="${fn:split(item,'/')[2]}" readonly />
					</div>
				</c:forEach>
				<input type="submit" class="btn btn-success my-3 proBtn" value="장바구니 더 담기">
			</div>
		</form>
		<form action="../product/product_page2" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input type="submit" class="btn btn-danger mb-3 proBtn" value="장바구니 비우기">
			</div>
		</form>
		<form action="purchase_success" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<input type="submit" class="btn btn-primary mb-3 proBtn" value="구매">
			</div>
		</form>

		<div class="col-4">
			<label for="totalPrice">총 금액</label>
			<input type="text" class="input-group-text my-3 marginAuto" id="totalPrice" name="totalPrice" value="${totalPrice}" readonly />
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/system_footer.jsp"%>