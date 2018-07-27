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
<script>

</script>
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
					<h3 class="blog-title">게시판 editor</h3>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<form id="frm" action="/boardList" class="form-horizontal"
								 method="get" >
								<h2 class="blog-post-title">게시판을 수정할 건가요!?</h2>
								<hr>
								자유게시판 생성 <input type="text" name="board_name"/>
								<select name="board_use" >
											<option value="Y">Y</option>
											<option value="N">N</option>
										</select>
								<input type="submit" value="생성"> <br>
								</form>
								<hr>
								
							<c:forEach items="${boardList}" var="vo">
									<form action="/updateBoard" class="form-horizontal"
									 method="post" enctype="multipart/form-data">
									 <input type="hidden" class="form-control" id="board_code" name="board_code"
										value="${vo.board_code}"> 
									게시판 이름:<input type="text" id="board_name" name="board_name" value="${vo.board_name}"/>
									 <input type="hidden" class="form-control" id="board_name" name="board_name"
										value="${vo.board_name}"> 
										<select name="board_use">
											<option value="Y">Y</option>
											<option value="N">N</option>
										</select>
											<button type="submit" class="btn btn-default">수정</button>
										<br>
										</form>
							</c:forEach>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>

			</div>
		</div>
	</div>
</body>
</html>

