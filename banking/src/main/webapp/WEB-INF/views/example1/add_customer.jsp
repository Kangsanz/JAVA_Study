<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.101.0">
<title>고객 가입 페이지</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/checkout/">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/defalut.css'/>">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>
<body class="bg-light">
	<div class="container">
		<main>
			<div class="py-5 text-center">

				<h2>신규 고객 가입</h2>
			</div>

			<div class="row g-5 justify-content-center">
				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">고객님의 정보를 입력해주세요</h4>

					<form class="needs-validation" action="add_customer" method="post" novalidate>
						<div class="row g-3">
							<div class="col-md-6">
								<label for="userId" class="form-label">고객ID</label>
								<div class="input-group has-validation">
									<input type="text" class="form-control" id="userId" name="userId" required="required">
								</div>
							</div>

							<div class="col-md-6">
								<label for="passwd" class="form-label">비밀번호</label>
								<div class="input-group has-validation">
									<input type="password" class="form-control" id="passwd" name="passwd" pattern=".{4,4}" required title="비밀번호는 4자리 입니다" placeholder="0000">
								</div>
							</div>

							<div class="col-md-6">
								<label for="name" class="form-label">이름</label>
								<div class="input-group has-validation">
									<input type="text" class="form-control" id="name" name="name" required="required">
								</div>
							</div>

							<div class="col-md-6">
								<label for="ssn" class="form-label">주민등록번호</label>
								<div class="input-group has-validation">
									<input type="tel" name="ssn" class="form-control" id="ssn" title="주민등록번호를 입력하세요." placeholder="900000-1232123" pattern="[0-9]{5,6}-[0-9]{6,7}" maxlength="14">
								</div>
							</div>

							<div class="col-md-6">
								<label for="phone" class="form-label">전화번호</label>
								<input type="tel" name="phone" class="form-control" id="phone" title="전화번호를 입력하세요." placeholder="010-0000-0000" pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" maxlength="13">
							</div>

							<input class="w-100 btn btn-primary btn-lg" type="submit" value="회원가입">
						</div>
					</form>
				</div>

				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">인터넷 뱅킹 가입 현황</h4>
					<ul>
						<li>회원ID : ${userId}</li>
						<li>비밀번호 : ${passwd}</li>
						<li>이름 : ${name}</li>
						<li>주민번호 : ${ssn}</li>
						<li>연락처 : ${phone}</li>
					</ul>

					<form class="d-flex justify-content-center" action="login" method="get">
						<input class="btn btn-secondary btn-lg" type="submit" value="돌아가기">
					</form>
				</div>
			</div>
		</main>

		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; 2022 Copyright Kangsan Park</p>
		</footer>
	</div>

	<script src="<c:url value='/resources/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='/resources/js/form-validation.js'/>"></script>
</html>