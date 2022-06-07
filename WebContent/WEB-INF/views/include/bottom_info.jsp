<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<link rel="stylesheet" href="${root }css/bottom_info.css">

<footer>
	<div class="container-fluid bg-secondary mt-5 mb-0 py-3">
		<div class="container nav justify-content-end">
			<a href="https://github.com/geneyee" target="_blank" class="bottom"><img src="${root }image/github.svg"></a><Br/>
			<a href="mailto:yujinlee.dev@gmail.com" target="_blank" class="bottom" style="margin-left:1%;"><img src="${root }image/gmail.svg"></a>
		</div>
	</div>
</footer>