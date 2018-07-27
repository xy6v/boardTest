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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(function() {
		$("#updateBtn").on("click", function() {
			console.log($("#frm").serialize());
			$("#frm").submit();

		});
	});
</script>
</head>

<body>
	<%@ include file="/common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
				<form id="frm" action="/postUpdate" class="form-horizontal"
					role="form" method="post" enctype="multipart/form-data">


					<div class="form-group">
						<label for="code" class="col-sm-2 control-label">게시글코드</label>
						<div class="col-sm-10">
							<label class="control-label">${postVo.post_code}</label>
							<input type="hidden" class="form-control" id="post_code" name="post_code"
								value="${postVo.post_code}" >
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">게시글 이름</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="post_name" name="post_name"
								value="${postVo.post_name}" placeholder="게시글 이름">
						</div>
					</div>
					
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="post_content" name="post_content"
								value="${postVo.post_content}" placeholder="게시글 내용">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="updateBtn" type="button" class="btn btn-default">수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
