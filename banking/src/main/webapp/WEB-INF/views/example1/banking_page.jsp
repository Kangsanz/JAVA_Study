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
<title>Jumbotron example · Bootstrap v5.2</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/jumbotron/">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>">

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

</head>
<body>
	<main>
		<div class="container py-4">
			<header class="pb-3 mb-4 border-bottom">
				<div href="#" class="d-flex align-items-center text-dark text-decoration-none" style="justify-content: space-between;">
					<span class="d-flex fs-4"><strong>Online Banking System</strong></span>
					<a href="<c:url value='login'/>" class="d-flex justify-content-end text-dark text-decoration-none">
						<span class="fs-5">로그아웃</span>
					</a>
				</div>
				<br>
				<p class="col-md-8 fs-4" style="text-align: center; margin: 0 auto;">${userId}님환영합니다.</p>
			</header>

			<div class="p-5 mb-4 bg-light rounded-3">
				<div class="container-fluid py-5">
					<h1 class="display-5 fw-bold">계좌 목록 확인</h1>
					<p class="col-md-8 fs-4">계좌 목록을 확인할 수 있습니다.</p>
					<form action="getAccounts_result" method="post">
						<input type="hidden" name="userId" value="${userId}" required="required">
						<input class="btn btn-primary btn-lg" type="submit" value="클릭">
					</form>
				</div>
			</div>

			<div class="row align-items-md-stretch">
				<div class="col-md-6">
					<div class="h-100 p-5 text-bg-dark rounded-3">
						<h2>신규 계좌 신청</h2>
						<p>신규 계좌를 신청할 수 있습니다.</p>
						<form action="add_account" method="get">
							<input type="hidden" name="userId" value="${userId}" required="required">
							<input class="btn btn-primary btn-lg" type="submit" value="클릭">
						</form>
					</div>
				</div>
				<div class="col-md-6">
					<div class="h-100 p-5 text-bg-dark border rounded-3">
						<h2>계좌 이체</h2>
						<p>계좌 이체를 할 수 있습니다.</p>
						<button class="btn btn-primary btn-lg" type="button" onclick="location.href='getAccounts'">클릭</button>
					</div>
				</div>
			</div>

			<div class="row align-items-md-stretch">
				<div class="col-md-6">
					<div class="h-100 p-5 bg-light border rounded-3">
						<h2>계좌 잔고 확인</h2>
						<p>계좌 잔고를 확인할 수 있습니다.</p>
						<form action="getBalance" method="get">
							<input type="hidden" name="userId" value="${userId}" required="required">
							<input class="btn btn-primary btn-lg" type="submit" value="클릭">
						</form>
					</div>
				</div>
				<div class="col-md-6">
					<div class="h-100 p-5 bg-light border rounded-3">
						<h2>계좌 이자 지급</h2>
						<p>계좌 이자를 지급할 수 있습니다.</p>
						<button class="btn btn-primary btn-lg" type="button" onclick="location.href='saveInterest'">클릭</button>
					</div>
				</div>
			</div>

			<footer class="pt-3 mt-4 text-muted border-top"> &copy; KangsanPark Copyright 2022 </footer>
		</div>
	</main>
</body>
</html>
