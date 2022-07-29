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
<title>Banking System Login</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
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

<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/signin.css'/>">

</head>
<body class="text-center" style="background-color: lightblue;">

	<main class="form-signin w-100 m-auto">
		<form action="login" method="post">
			<h1 class="h3 mb-3 fw-normal">
				<strong class="logo">Banking System Login</strong><br>
			</h1>

			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput" name="userId" placeholder="아이디를 입력해주세요.">
				<label for="floatingInput">고객ID</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword" name="passwd" placeholder="Password">
				<label for="floatingPassword">비밀번호</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
			<div class="mb-3">
				<a href="add_customer">회원가입</a>
			</div>
			<p class="mt-5 mb-3 text-muted">&copy; KangsanPark Copyright 2022</p>
		</form>
	</main>

	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function() {
			let message = "${msg}";
			if (message != "") {
				alert(message);
			} else {
			}
		})
	</script>
</body>
</html>
