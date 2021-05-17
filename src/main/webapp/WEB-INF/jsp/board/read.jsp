<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="../common/base.jspf"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${content.title}</title>
</head>

<body>
    <jsp:include page="../common/header.jsp" />
    <section class="container is-max-desktop my-3">
        <div class="board-container box">
            <div class="notification is-primary mb-0 board-head">
                <h1 class="is-size-3">${content.title}</h1>
            </div>
            <div class="p-5 board-inner">
                <h1 class="is-size-5">${content.description}</h1>
            </div>
            <div class="is-flex is-justify-content-center px-5 pt-6">
                <a class="button is-secondary is-light mr-2" title="This is the first page" href="/board">목록</a>
                <a class="button is-primary is-light mr-2" title="This is the first page" href="/board">수정</a>
                <a class="button is-danger is-light mr-2" title="This is the first page" href="/board">삭제</a>
            </div>
        </div>
    </section>
</body>

<script>
    $(document).ready(function () {
        console.log("${content.toString()}")
    })
</script>


<script src="/static/js/read-board.js">
</script>

</html>