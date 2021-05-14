<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<%@ include file="common/base.jspf"%>
<link rel="stylesheet" href="/static/css/board.css">
<title>Board</title>
</head>
<script>
console.log(${models})
</script>
<body>
	<jsp:include page="common/header.jsp" />
	<div class="container is-max-desktop my-3">
		<div class="board-container box">
			<div class="notification is-primary mb-0 board-head">
				<h1 class="is-size-3">Board</h1>
			</div>
			<div class="px-3 py-5">
				<h1>Board Starts Here</h1>
				<c:forEach var="name" items="${models}" varStatus="status">
					<h6 class="is-size-2">${status.count}
						:
						<c:out value="${name}" />
					</h6>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>