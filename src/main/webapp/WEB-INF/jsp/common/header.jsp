<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.nav-root {
		box-shadow: 1px 1px 1px 0 rgba(0, 0, 0, 0.1);
	}
</style>



<nav class="navbar nav-root" role="navigation" aria-label="main navigation">
	<div class="navbar-brand">
		<a class="navbar-item" href="/"> <img src="/static/spark-7.svg" width="112" height="28">
		</a> <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false"
			data-target="navbarBasicExample">
			<span aria-hidden="true"></span> <span aria-hidden="true"></span> <span aria-hidden="true"></span>
		</a>
	</div>

	<div id="navbarBasicExample" class="navbar-menu">
		<div class="navbar-start">
			<a class="navbar-item" href="/board"> 게시판 </a>
		</div>

		<div class="navbar-end">
			<div class="navbar-item">
				<c:choose>
					<c:when test="${user.id != null}">
						<h6 class="h6 is-size-5 mr-3">${user.name}</h6>
						<a class="button is-primary" href="/logout"> <strong>Sign out</strong></a>
					</c:when>
					<c:otherwise>
						<a class="button is-primary" href="/register"> <strong>Sign up</strong> </a>
						<a class="button is-light" href="/login"> Log in </a>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
</nav>

<script src="/static/js/auth-wrap-control.js"></script>