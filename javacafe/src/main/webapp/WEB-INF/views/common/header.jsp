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
<title>Java Cafe System</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/jumbotron/">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>">

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

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/default.js'/>"></script>

</head>
<body>
	<main>
		<div class="position-relative container py-4 mainBgColor">
			<header class="d-flex flex-wrap align-items-center justify-content-center py-3 mb-4 border-bottom">
				<a href="<c:url value='../product/product_page'/>" class="d-flex align-items-center text-dark text-decoration-none">
					<span class="fs-3 logo text-center">Java Cafe</span>
				</a>
			</header>
			<div class="position-absolute top-0 end-0" style="transform: translate(-30%, 60%);">
				<a href="<c:url value='../product/addProduct_page'/>" class="btn btn-dark">
					<span class="fs-5">관리자</span>
				</a>
			</div>