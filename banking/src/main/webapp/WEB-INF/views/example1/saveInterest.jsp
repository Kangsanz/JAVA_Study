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
<title>Online Banking System Page</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/jumbotron/">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/defalut.css'/>">

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Rajdhani:wght@300;400;500;600;700&display=swap')
	;

.logo {
	font-family: 'Rajdhani', sans-serif;
	font-weight: bold;
}

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
			<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
				<a href="#" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
					<span class="fs-3 logo">KS BANK</span>
				</a>

				<div class="col-md-3 text-end">
					<a href="<c:url value='login'/>" class="btn btn-outline-primary me-2">
						<span class="fs-5">로그인/로그아웃</span>
					</a>
				</div>
				<p class="col-md-8 fs-4" style="text-align: center; margin: 0 auto;">${userId}님&nbsp환영합니다.</p>
			</header>

			<div class="row p-5 mb-4 bg-light rounded-3" style="position: relative;">
				<div class="container-fluid col-md-6">
					<h1 class="display-5 fw-bold">계좌 확인</h1>
					<p class="col-md-8 fs-4">이자를 지급할 계좌를 선택하세요.</p>
				</div>
				<div class="container-fluid col-md-6" style="height: 250px; overflow: auto;">
					<h4>계좌번호 / 잔액 / 이자율</h4>
					<form action="saveInterest" method="post" style="display: flex;">
						<div style="display: flex; flex-direction: column; margin-right: 15px;">
						</div>
						<div style="display: flex; flex-direction: column; margin-right: 15px;">
						</div>
						<div style="display: flex; flex-direction: column; margin: 0 15px 0 15px;">
						</div>
						<div style="display: flex; flex-direction: column; margin-right: 30px; justify-content: space-around;">
						</div>
						<input class="btn btn-primary btn-lg" type="submit" value="이자 지급" style="position: absolute; width: 114px; height: 48px; right: 50%; bottom: 0; transform: translate(50%, -200%);">
					</form>
				</div>
				<form class="d-flex justify-content-center" action="banking_page" method="post">
					<input type="hidden" name="userId" value="${userId}">
					<input class="btn btn-secondary btn-lg" type="submit" value="돌아가기">
				</form>
			</div>

			<footer class="pt-3 mt-4 text-muted border-top"> &copy; KangsanPark Copyright 2022 </footer>
		</div>
	</main>
</body>
</html>
