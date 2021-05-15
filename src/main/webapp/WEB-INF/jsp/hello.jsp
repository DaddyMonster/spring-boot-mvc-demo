<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script>
		window.onload = () => console.log("Hello", "${name}");
	</script>
	<title>View Test Page</title>
</head>

<body>
	<main>
		<h2>Hello There! ${name}</h2>
		<div>JSP List Test</div>
		<c:forEach var="item" items="${list}" varStatus="idx"> ${idx.index}, ${item} <br />
		</c:forEach>

		<br></br>
		<h1>LUV Docker</h1>
		<img src="/static/docker.png" />
	</main>
</body>

</html>