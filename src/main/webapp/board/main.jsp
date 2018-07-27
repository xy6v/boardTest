<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
</head>

<body>

	<!-- top -->
	<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@ include file="/common/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="blog-header">
					<h1 class="blog-title">게시판 ${param.redirectform}</h1>
					<p class="lead blog-description">Jsp / Spring.</p>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<h2 class="blog-post-title">게시판</h2>
							<p class="blog-post-meta">2018.7.25, room 207</p>

							<p>jsp를 이용하여 게시판 만들기</p>
							<hr>

							<h3>상세설명</h3>
							<p>JSP를 이용하여 게시판 구성하여 화면구현</p>
							<ul>
								<li>게시판 생성클릭</li>
								<li>게시판 생성페이지에서 사용유무 설정</li>
								<li>게시판의 글 목록 확인</li>
								<li>게시판에 새글쓰기</li>
								<li>게시판의 글 수정확인</li>
								<li>게시판의 글 삭제확인</li>
							</ul>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
