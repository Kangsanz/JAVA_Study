<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/views/common/system_header.jsp"%>

<h3>현재 카테고리 목록</h3>
<div class="col-2">
	<label for="bigCategory" class="form-label">큰 카테고리</label>
	<div class="input-group has-validation">
		<select class="input-group has-validation col-md-12 text-center" id="bigCategory" name="bigCategory">
			<c:forEach var="item" items="${bigCategoryList}">
				<option value="<c:out value="${item}" />"><c:out value="${item}" /></option>
			</c:forEach>
		</select>
	</div>
</div>

<div class="col-2">
	<label for="midCategory" class="form-label">작은 카테고리</label>
	<div class="input-group has-validation">
		<select class="input-group has-validation col-md-12 text-center" id="midCategory" name="midCategory">
			<c:forEach var="item" items="${midCategoryList}">
				<option value="<c:out value="${item}" />"><c:out value="${item}" /></option>
			</c:forEach>
		</select>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/system_footer.jsp"%>