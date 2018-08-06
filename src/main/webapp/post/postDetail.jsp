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
	<%@ include file="/common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form"
					action="/postUpdate" method="get">
					<div class="form-group">
						<label for="post_code" class="col-sm-2 control-label">현게시물
							코드</label>
						<div class="col-sm-10">
							<label class="control-label">${postVo.post_code}</label> <input
								type="hidden" name="post_code" value="${postVo.post_code}" />

						</div>
					</div>
						<div class="form-group">
						<label for="post_parent" class="col-sm-2 control-label">게시물
							코드</label>
						<div class="col-sm-10">
							<label class="control-label">${postVo.post_parent}</label> <input
								type="hidden" name="post_parent" value="${postVo.post_parent}" />

						</div>
					</div>
					
					<div class="form-group">
						<label for="std_id" class="col-sm-2 control-label">학생 아이디</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.std_id}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="post_name" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${postVo.post_name}</label>

						</div>
					</div>

					<div class="form-group">
						<label for="post_content" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<label class="control-label">${postVo.post_content}</label>
						</div>
					</div>

					<div class="col-sm-offset-2 col-sm-80">
						<div class="control-label">
							<button type="submit" class="btn btn-default">게시글 수정</button>
						</div>
					</div>
					<div class="form-group col-md-4">
								<label for="attachment">첨부파일 : </label>
								<c:choose>
									<c:when test="${uploadList == null }">
										<input type="text" value="첨부파일 없음" readonly="readonly">
									</c:when>
								<c:otherwise>
								<c:forEach items="${uploadList }" var="uploadVo">
								<li><a href="/fileDown?upload=${uploadVo.upload}">${uploadVo.uploadname}" 
								<i class="fa fa-download" aria-hidden="true"></i>
								</a></li> 
								</c:forEach>
								</c:otherwise>
								</c:choose>

							</div>
					
					
				</form>
				<%-- <form id="delete" class="form-horizontal" role="form"
					action="/postDelete?post_code=${post_code}&board_code=${board_code}" method="get">
					<input type="hidden" class="form-control" id="post_code"
						name="post_code" value="${postVo.post_code}" /> <input
						type="hidden" class="form-control" id="board_code"
						name="board_code" value="${postVo.board_code}" />
					<div class="control-label">
						<button id="deleteBtn" type="submit" class="btn btn-default">게시글
							삭제</button>
					</div>
				</form> --%>
					<form id="comment" class="form-horizontal" role="form"
					action="/postDelete" method="get">
					<input type="hidden" class="form-control" id="post_code"
						name="post_code" value="${postVo.post_code}" /> <input
						type="hidden" class="form-control" id="board_code"
						name="board_code" value="${postVo.board_code}" />
					<div class="control-label">
						<button id="commentBtn" type="submit" class="btn btn-default">게시글 삭제</button>
					</div>
				</form>
				

				<%-- 	<form id="delete" class="form-horizontal" role="form"
										action="/postNew?post_parent=${post_code}" method="get"> --%>
										
					<form id="comment" class="form-horizontal" role="form"
					action="/post/postRp.jsp">
					<div class="control-label">
						<input type="hidden" class="form-control" id="board_code"
						name="board_code" value="${postVo.board_code}" />
						<input type="hidden" name="post_parent" value="${postVo.post_code}"/>
						<button id="commentBtn" type="submit" class="btn btn-default">답글쓰기</button>
					</div>
				</form>




				<div class="form-group">
					<label for="post_content" class="col-sm-2 control-label">댓글목록:</label>
					<div class="table-responsive">
						<c:forEach items="${commentsList}" var="vo">
							<form class="form-horizontal" role="form"
								action="/commentsUpdate" method="get"
								enctype="multipart/form-data">
								<div class="col-sm-10">
									<label class="control-label">${vo.comments_content}</label> <label
										class="control-label">[${studentVo.std_id}
										/${vo.comments_dt}]</label> <input type="hidden" id="comments"
										name="comments_code" value="${vo.comments_code}" /> <br>
									<input type="hidden" id="board" name="board_code"
										value="${postVo.board_code}" /> <input type="hidden"
										id="post" name="post_code" value="${postVo.post_code}" /> <br>
									<div class="col-sm-offset-2 col-sm-80">
										<input type="hidden" id="comments_code" name="comments_code"
											value="${commetnsVo.comments_code}" />
										<div class="control-label">
											<input type="submit" class="btn btn-default" value="댓글삭제">
										</div>
									</div>
								</div>
							</form>
						</c:forEach>
					</div>
				</div>


				<form id="insertComment" class="form-horizontal" role="form"
					action="/commentsList" method="post">
					<input type="hidden" id="board" name="board_code"value="${postVo.board_code}">
					 <input type="hidden" name="post_content" value="${postVo.post_content}"> 
						<input type="hidden" name="post_name" value="${postVo.post_name}">
					<input type="hidden" id="post_code" name="post_code" value="${postVo.post_code}">
					<label for="comments_content" class="col-sm-2 control-label">댓글작성:</label>
					 <input type="text"name="comments_content" />
					<button type="submit" class="btn btn-default">저장</button>
					
			</form>
			</div>
		</div>
	</div>
</body>
</html>
