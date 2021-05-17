<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">

<head>
    <%@ include file="../common/base.jspf"%>
    <link rel="stylesheet" href="/static/css/board.css">
    <title>Board</title>
</head>

<body>
    <jsp:include page="../common/header.jsp" />
    <section class="container is-max-desktop my-3">
        <div class="board-container box">
            <div class="notification is-primary mb-0 board-head is-flex">
                <h1 class="is-size-4">
                    게시판 목록
                </h1>
                <a href="/board/write" class="ml-auto">
                    <button class="button is-primary">글쓰기</button>
                </a>
            </div>
            <div class="px-3 py-5 board-inner">
                <c:if test="${pageMaker.totalCount == 0}">
                    <h1 class="has-text-centered block is-size-3 has-text-weight-bold">NO ITEMS!</h1>
                </c:if>
                <c:forEach var="item" items="${boardList}" varStatus="status">
                    <a class="list-wrapper" href="/board/read/${item.id}">
                        <h4 class="title">
                            ${item.title}
                        </h4>
                        <h6 class="list-info ml-auto">${item.issuerId} 번 유저 조인예정</h6>
                        <fmt:formatDate var="createdAtFormmated" value="${item.createdAt}" pattern="yyyy-MM-dd" />
                        <h6 class="list-info">${createdAtFormmated}</h6>
                    </a>
                </c:forEach>
            </div>
            <nav class="pagination px-5 py-2" role="navigation" aria-label="pagination">
                <a class="pagination-previous" title="This is the first page"
                    href="<c:url value='/board?page=${pageMaker.cri.page - 1}'/>">이전</a>
                <a class="pagination-next" href="<c:url value='/board?page=${pageMaker.cri.page + 1}'/>">다음</a>
                <ul class="pagination-list">
                    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
                        <li>
                            <a class="pagination-link" id="page-btn-${index}" aria-label="page-${index}"
                                aria-current="page" href="<c:url value='/board?page=${index}'/>">${index}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </section>
</body>
<script>
    var currentPageIndex = "${pageMaker.cri.page}";
    var prev = ${pageMaker.prev}
    var next = ${pageMaker.next};
</script>
<script src="/static/js/board-list.js"></script>


</html>