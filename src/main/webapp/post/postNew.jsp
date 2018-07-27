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

<title>새글쓰기</title>

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
					<h3 class="blog-title">글쓰기 페이지</h3>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<form id="frm" action="/postNew" class="form-horizontal"
								 method="get" enctype="multipart/form-data">
								<h2 class="blog-post-title">새글을 쓰겠다구요~~?</h2>
								<hr>
								<input type="hidden" class="form-control" id="board_code" name="post_code" value="${param.post_code}" > 
								<input type="hidden" class="form-control" id="post_parent" name="post_parent" value="${param.post_parent}" > 
								<input type="hidden" class="form-control" id="board_code" name="board_code" value="${param.board_code}" > 
								글쓴이<label class="control-label">${studentVo.std_id}</label> <br>
								제목 <input type="text" name="post_name"/><br>
								내용 <input type="text" name="post_content"/><br>
								<input type="submit" value="생성"> <br>
								</form>
								<hr>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>

			</div>
		</div>
	</div>
</body>
</html>

