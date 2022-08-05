<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div id="content">
	<div class="content-info">
		<h2 class="title">상품등록</h2>
	</div>
	<div class="content-body">
		<div class="form-table">
			<table class="search-table marginAuto">
				<tr>
					<th>카테고리</th>
					<td>
						<form class="searchform" action="add_product" method="post" enctype="multipart/form-data">
							<select name="bigCategory" class="bigCategory" style="width: 204px; height: 28px;">
								<c:forEach var="item" items="${bigCategoryListName}">
									<option value="${item}">${item}</option>
								</c:forEach>
							</select>

							<select name="midCategory" class="midCategory" style="width: 204px; height: 28px;">
								<c:forEach var="item" items="${midCategoryListName}">
									<option value="${item}">${item}</option>
								</c:forEach>
							</select>
					</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td>
						<input type="text" name="proName" class="searchinput">
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>
						<input type="number" name="proPrice" class="searchinput">
					</td>
				</tr>
				<tr>
					<th>상품이미지</th>
					<td>
						<input type="file" name="proImage" class="searchinput">
					</td>
				</tr>
				<tr>
					<td>
						<h4>${success}</h4>
					</td>
					<td colspan="2">
						<a class="btn btn-danger my-3" href="<c:url value='product_page'/>">취소</a>
						<button class="btn btn-primary my-3" type="submit">저장</button>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/system_footer.jsp"%>