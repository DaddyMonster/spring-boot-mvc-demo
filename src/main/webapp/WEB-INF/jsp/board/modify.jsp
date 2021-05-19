<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="../common/base.jspf"%>
    <title>Edit Post</title>
</head>

<body>
    <jsp:include page="../common/header.jsp" />
    <section class="container is-max-desktop my-3">
        <form:form class="box px-6" modelAttribute="registerBoardDto" method="POST"
			action="${ pageContext.servletContext.contextPath }/board/modify/${boardId}/submit">
			<h1 class="h1 py-5 has-text-centered is-size-3">게시판 수정</h1>
			<div class="field">
				<label class="label">Title</label>
				<div class="control">
					<form:input id="title-input" class="input" type="text" placeholder="글을 수정하세요" path="title"/>
						<span class="">
							<form:errors path="title" />
						</span>
				</div>
			</div>

			<div class="field">
				<label class="label">본문</label>
				<div class="control">
					<form:textarea id="description-input" class="textarea" rows="10" type="text" placeholder="본문 입력" path="description"/>
					<span class=""><form:errors path="description" /></span>
				</div>
			</div>
			<div class="is-flex is-justify-content-center py-3">
				<button class="button is-primary" type="submit">등록</button>
			</div>
		</form:form>
    </section>
</body>
<script>
var model = "${registerBoardDto}"
</script>
<script src="/static/js/modify.js">
</script>

</html>