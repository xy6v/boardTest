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

<title>Login</title>

<!-- Bootstrap core CSS -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/login/signin.css" rel="stylesheet">
<!-- 경로를 똑바로하자. -->

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!--  <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

<%@ include file="/common/jquery.jsp"%>
<script>
	function getCookie(name) {
		var cookies = document.cookie;

		var cookieArr = cookies.split("; ");
		var cookieResult = "";

		for ( var i in cookieArr) {
			var cookie = cookieArr[i];
			var cookieNameValue = cookie.split("=");

			var cookieName = cookieNameValue[0];
			var cookieValue = cookieNameValue[1];

			if (name == cookieName) {
				cookieResult = cookieValue;
				break;

			}
		}
		return cookieResult;

	}
	
	//쿠키추가
	function setCookie(cookieName, cookieValue, expires){
		var dt = new Date();
		dt.setDate(dt.getDate()+parseInt(expires));
		document.cookie=cookieName+"="+cookieValue+"; path=/; expries="+dt.toGMTString();
	}
	
	//쿠키삭제
	function deleteCookie(cookieName){
		setCookie(cookieName,"",-1);
	}
	
	$(function(){
		if (getCookie("rememberMe") == "y") {
			//userId input에 userId cookie 값을 설정
			$("#userId").val(getCookie("userId"));
			$("#rememberMe").attr("checked",true)
			$("#rememberMe").val(getCookie("rememberMe"));
		}
		
		//rememberMe 체크박스 클릭이벤트
		$("#rememberMe").on("click",function(){
			if($(this).is("checked")){
				//rememberMe Cookie 설정
				setCookie("rememberMe","y",30);
				setCookie("std_id",$("#std_id").val(),30);
			}else{
				//쿠키 제거
				deleteCookie("rememberMe");
			}
		});
	});
	
</script>

</head>

<body>
	<!-- 
		1.사용자가 로그인 화면을 접속한다 (localhost:8180/login/login.jsp)
		2.사용자가 아이디, 비밀번호를 입력후 singin 버튼을 클릭
		 	->signin 버튼이 속한 form 태그의 action 속성에 설정된 url로 요청
		3.LoginServlet 파라미터 (userId, password)를 확인후 고정된 값을 비교
		  같을 경우 response객체의 writer 객체를 이요하여 화면에  - "접속 성공"
		  틀릴 경우 response객체의 writer 객체를 이요하여 화면에  - "접속 실패"
		  메시지를 출력
		  
	 -->
	<div class="container">

		<form class="form-signin" action="/loginServlet" method="post">
			<h2 class="form-signin-heading">Login화면입니다.</h2>
			<label for="std_id" class="sr-only">student Id</label> 
		
			<%
		//	String userId = request.getParameter("userId");
			//		userId= userId==null?"":userId;
			%>
			<input
				type="text" name="std_id" id="std_id" class="form-control"
				placeholder="std_id" value="${param.std_id}" required autofocus> 
				<label
				for="inputPassword" class="sr-only">pass</label> <input
				type="pass" name="pass" id="pass" class="form-control"
				placeholder="pass" required>

			<div class="checkbox">

				<label> <input type="checkbox" id="rememberMe"
					name="rememberMe" value=""> Remember me
				</label>

			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
