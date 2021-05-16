<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
	<%@ include file="common/base.jspf"%>
	<link rel="stylesheet" href="/static/css/board.css">
	<title>Board</title>
</head>

<body>
	<jsp:include page="common/header.jsp" />
	<div class="container is-max-desktop my-3">
		<div class="board-container box">
			<div class="notification is-primary mb-0 board-head">
				<h1 class="is-size-3">Board</h1>
			</div>
			<div class="px-3 py-5 board-inner">
				<c:if test="${pageMaker.totalCount == 0}">
					<h1 class="has-text-centered block is-size-3 has-text-weight-bold">NO ITEMS!</h1>
				</c:if>
				<c:forEach var="item" items="${boardList}" varStatus="status">
					<div class="is-flex is-align-items-center is-space-between">
						<h6 class="is-size-6">
							${item.title}
						</h6>
					</div>
				</c:forEach>
			</div>
			<nav class="pagination px-5 py-2" role="navigation" aria-label="pagination">
				<a class="pagination-previous" title="This is the first page" disabled>다음</a>
				<a class="pagination-next">이전</a>
				<ul class="pagination-list">
					<li>
						<a class="pagination-link is-current" aria-label="Page 1" aria-current="page">1</a>
					</li>
					<li>
						<a class="pagination-link" aria-label="Goto page 2">2</a>
					</li>
					<li>
						<a class="pagination-link" aria-label="Goto page 3">3</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</body>
<script>
	console.log("${boardList}", "${pageMaker.totalCount}", "${pageMaker.startPage}", "${pageMaker.endPage}");
</script>

</html>