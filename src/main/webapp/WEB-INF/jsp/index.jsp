<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<%@ include file="common/base.jspf"%>
	<link rel="stylesheet" href="/static/css/index.css">
	<title>Home</title>
</head>

<script>
	window.onload = () => console.log("Hello", "${name}");
</script>

<body>
	<jsp:include page="common/header.jsp" />
	<main>

		<section class="jumbo">
			<h1>Let's Write some blog posts!</h1>
		</section>
		<div class="is-flex is-justify-content-center is-align-items-center my-6">
			<a href="/board" class="button is-primary px-6">TAKE ME THERE</a>
		</div>
	</main>
</body>

</html>