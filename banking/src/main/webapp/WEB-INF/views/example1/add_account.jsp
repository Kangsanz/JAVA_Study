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
<title>계좌 개설 페이지</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/checkout/">
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
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

				<h2>신규 계좌 개설</h2>
			</div>

			<div class="row g-5 justify-content-center">
				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">계좌 타입을 설정해 주세요.</h4>

					<form class="needs-validation" action="add_account" method="post" novalidate>
						<div class="row g-3">
							<div class="col-md-6">
								<label for="userId" class="form-label">고객ID</label>
								<div class="input-group has-validation">
									<input type="text" class="form-control" id="userId" name="userId" value="${userId}" readonly="readonly">
								</div>
							</div>

							<div class="col-md-6">
								<label for="accountPasswd" class="form-label">계좌 비밀번호</label>
								<div class="input-group has-validation">
									<input type="text" class="form-control" id="accountPasswd" name="accountPasswd" required="required">
								</div>
							</div>

							<div class="col-md-6">
								<label for="accType" class="form-label">계좌 종류</label>
								<select class="form-select" id="accType" name="accType" required>
									<option value="S" selected="selected">SavingsAccount</option>
									<option value="C">CheckingAccount</option>
								</select>
							</div>

							<div class="col-md-6">
								<label for="balance" class="form-label">초기 금액 설정</label>
								<div class="input-group has-validation">
									<input type="number" class="form-control" id="balance" name="balance" value="10000" required="required" />
								</div>
							</div>
							<input type="hidden" name="interestRate" value="2.0">
							<input class="w-100 btn btn-primary btn-lg" type="submit" value="계좌 개설">
						</div>
					</form>
				</div>

				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">계좌 개설 현황</h4>
					<ul>
						<li>계좌번호 : ${accountNum}</li>
						<li>계좌 비밀번호 : ${accountPasswd}</li>
						<li>계좌종류 : ${accType}</li>
						<li>잔액 : ${balance}</li>
						<li>이자율 : ${interestRate}%</li>
					</ul>

					<form class="d-flex justify-content-center" action="banking_page" method="post">
						<input type="hidden" name="userId" value="${userId}">
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