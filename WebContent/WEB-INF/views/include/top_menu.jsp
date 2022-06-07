<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Secular+One&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${root}css/main.css">
<!-- 상단 메뉴 부분 -->
<nav
	class="navbar navbar-expand-md navbar-secondary bg-secondary fixed-top">
	<div class="container">
		<a id="mainLogo" class="navbar-brand display-1 text-white" href="${root }main">Board project</a>
		<div class="btn-group" role="group">
			<button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<img src="${root }image/user.svg">
			</button>
			<div id="subLogo" class="dropdown-menu bg-light" aria-labelledby="btnGroupDrop1">
				<c:choose>
					<c:when test="${loginUserBean.userLogin == true }">
						<h6><a href="${root }user/modify" class="nav-link">정보수정</a></h6>
						<hr class="dropdown-divider">
						<h6><a href="${root }user/logout" class="nav-link">로그아웃</a></h6>
					</c:when>
					<c:otherwise>
						<h6><a href="${root }user/login" class="nav-link">로그인</a></h6>
						<hr class="dropdown-divider">
						<h6><a href="${root }user/join" class="nav-link">회원가입</a></h6>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</nav>
<hr />
<div>
	<nav class="navbar navbar-expand-sm navbar-light bg-light pt-4">
		<div class="container">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navMenu">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div id="subLogo" class="collapse navbar-collapse" id="navMenu">
				<ul class="navbar-nav">
					<c:forEach var='obj' items='${topMenuList }'>
						<li class="nav-item"><a href="${root }board/main?board_info_idx=${obj.board_info_idx}"
							class="nav-link">${obj.board_info_name }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</nav>
</div>
