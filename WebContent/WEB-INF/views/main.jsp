<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:url var='root' value='/' /> --%>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${root}css/bottom_info.css">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<!-- font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${root}css/main.css">
<link rel="stylesheet" href="${root}css/bottom_info.css">
</head>
<body>
<div id="wrap">
<!-- 상단 메뉴 -->
<c:import url="/WEB-INF/views/include/top_menu.jsp" />

<!-- 게시판 미리보기 부분 -->
<div class="container" style="margin-top:30px">
	<div class="row">
		<c:forEach var='sub_list' items="${list }" varStatus="idx"><!-- idx.index하면 반복횟수 구할 수 있음 -->
		<div class="col-lg-6" style="margin-top:20px">
			<div class="card shadow">
				<div class="card-body">
					<h5 class="card-title">${board_list[idx.index].board_info_name }</h5>
					<table class="table table-hover" id='board_list'>
						<thead>
							<tr>
								<th class="text-center w-25">글번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th class="text-center w-25 d-none d-xl-table-cell">작성날짜</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var='obj' items="${sub_list }">
							<tr>
								<td class="text-center">${obj.content_idx }</td>
								<th><span class="d-inline-block text-truncate" style="max-width: 100px;"><a href='${root }board/read?board_info_idx=${board_list[idx.index].board_info_idx}&content_idx=${obj.content_idx}&page=1'>${obj.content_subject }</a></span></th>
								<td>${obj.content_writer_name }</td>
								<td class="text-center d-none d-xl-table-cell">${obj.content_date }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<a href="${root }board/main?board_info_idx=${board_list[idx.index].board_info_idx}" class="btn btn-secondary float-right">더보기</a>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
</div>
<!-- footer -->
<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>









