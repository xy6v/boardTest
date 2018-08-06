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
<script src="/SE2/js/HuskyEZCreator.js"></script>

<script type="text/javascript">
	var oEditors = []; 

	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "post_content", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});
		$("#save").click(function() {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["post_content"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#frm").submit();
		});
	});
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
					<h3 class="blog-title">글쓰기 페이지</h3>
				</div>

				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<form id="frm" action="/postRplist?board_code=${param.board_code}" class="form-horizontal"
								 method="post" enctype="multipart/form-data">
								<h2 class="blog-post-title">답글을  쓰겠다구요~~?</h2>
								${post_parent}:${param.post_parent}
								<hr>
<%-- 								<input type="hidden" class="form-control" name="board_code" value="${param.board_code}" > --%>
								<input type="hidden" id="post_parent" name="post_parent" value="${param.post_parent}" >  
								<input type="text" id="board_code" name="board_code" value="${param.board_code}" > 
								글쓴이 <label class="control-label">${studentVo.std_id}</label> <br>
									 제목 <input type="text" name="post_name" /><br>
								<!-- 내용 <input type="text" name="post_content"/><br> -->

								<!-- contents -->
								<div class="form-group marbtm-30">
									<label for="smarteditor">내용</label>
									<textarea name="post_content" id="post_content" rows="10"
										cols="100" style="width: 100%; height: 412px;"></textarea>
								</div>
								
								<!-- 첨부파일 -->
								<input type="file" name="uploadName" multiple="multiple">
			
								<input type="button" id="save" value="저장"><br>
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

