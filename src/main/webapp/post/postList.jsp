<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="post.model.PostVo"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/bootstrap/css/dashboard.css" rel="stylesheet">
<link href="/bootstrap/css/blog.css" rel="stylesheet">
<link href="/bootstrap/css/common.css" rel="stylesheet">

<script>
	$(function(){
		$("table tbody tr").on("click",function(){
			//tr태그의 data-id속성 값을 읽어서 input 태그의 id값으로 설정
			//form 태그를 submit
			$("#post_code").val($(this).data("id"));
			$("#board_code").val($("#board").val());
			$("#std_id").val($("#id").val());
			$("#frm").submit();
			});
		});
</script>
</head>

<body>
	<%@ include file="/common/top.jsp"%>
	
	<form id="frm" action="/postDetail" method="get">
		<input type="hidden" name="post_code" id="post_code" value="${postVo.post_code }">
		<input type="hidden" name="post_parent" id="post_parent">
		<input type="hidden" name="board_code" id="board_code">
		<input type="hidden" name="std_id" id="std_id">
	</form>
	
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<thead>
									<tr >
										<td>게시판 코드</td>
										<td>게시글 코드</td>
										<td>작성자</td>
										<td>제목</td>
										<td>등록 일자(yyyy-mm-dd)</td>
									</tr>
								</thead>
								 <tbody>
									<c:forEach items="${pageList}" var="vo">
									<c:choose>
									<c:when test="${vo.post_use=='Y'}">
										<tr data-id="${vo.post_code}">
										<input type="hidden" id="post" name="post_code" value="${vo.post_code}"/>
										<input type="hidden" id="board" name="board_code" value="${vo.board_code}"/>
											<td>${vo.board_code}</td>
											<td>${vo.post_code}</td>
											<td>${studentVo.std_id}</td>
											<td>${vo.post_name}</td>
											<td><fmt:formatDate value="${vo.post_dt}"
													pattern="yyyy-MM-dd" /></td>
										</tr>
										</c:when>
										<c:when test="${vo.post_use=='N'}">
										<tr style="pointer-events:none;">
										<td>${vo.board_code}</td>
										<td>${vo.post_code}</td>
										<td>${studentVo.std_id}</td>
										<td>삭제된게시물입니다</td>
										<td><fmt:formatDate value="${vo.post_dt}"
													pattern="yyyy-MM-dd" /></td>
										</tr>
										</c:when>
										</c:choose>
									</c:forEach>
								</tbody> 
							</table>
						</div>

						<a href="/post/postNew.jsp?board_code=${board_code}" class="btn btn-default pull-right">새글쓰기</a>
						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

