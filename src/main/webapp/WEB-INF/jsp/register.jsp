<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="ko">

<head>
	<%@ include file="common/base.jspf"%>
	<link rel="stylesheet" href="/static/css/form.css">
	<title>Register</title>
</head>

<body>
	<main class="full-flex-container">
		<form:form class="box px-6" modelAttribute="registerDto" method="POST"
			action="${ pageContext.servletContext.contextPath }/register-submit">
			<h1 class="h1 py-5 has-text-centered is-size-3">Register</h1>
			<div class="field">
				<label class="label">Email</label>
				<div class="control">
					<form:input class="input" type="email" placeholder="e.g. spark@example.com" path="email" />
					<span class="">
						<form:errors path="email" />
					</span>
				</div>
			</div>
			<div class="field">
				<label class="label">Name</label>
				<div class="control">
					<form:input class="input" type="text" placeholder="e.g. 홍길동" path="name" />
					<span class="">
						<form:errors path="name" />
					</span>
				</div>
			</div>
			<div class="field">
				<label class="label">Password</label>
				<div class="control">
					<form:input class="input" type="password" placeholder="********" path="password" />
					<span class="">
						<form:errors path="password" /></span>
				</div>
			</div>
			<div class="field">
				<label class="label">Password</label>
				<div class="control">
					<form:input class="input" type="password" placeholder="********" path="passwordCheck" />
					<span class="">
						<form:errors path="passwordCheck" /></span>
				</div>
			</div>
			<div class="is-flex is-justify-content-center py-3">
				<button class="button is-primary" type="submit">로그인</button>
			</div>
		</form:form>
	</main>
</body>

</html>