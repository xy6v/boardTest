<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/board/board.jsp">게시판 생성<span
				class="sr-only">(current)</span></a></li>
	<%-- 	<c:forEach items="${boardList}" var="vo">
		<c:choose>
		<c:when test="${boardVo.board_use== 'Y'}">
			<li class="active"><a href="/postList?board_code=${vo.board_code}&page=1&pageSize=10?board_use=${BoardVo.board_use=='Y'}"/>${vo.board_name}</a></li>	
		</c:when>
		<c:when test="${boardVo.board_use== 'N'}">
			<li class="active" ><a href="/postList?board_code=${vo.board_code}&page=1&pageSize=10" style="display: none;">${vo.board_name}</a></li>
			</c:when>
		</c:choose>
		</c:forEach>
		 --%>
		
		<c:forEach items="${boardList}" var="vo">
			<c:choose>
				<c:when test="${vo.board_use== 'Y' }">
					<li class="list-item active" id="activeBoard"><a href="/postList?board_code=${vo.board_code}&page=1&pageSize=10">${vo.board_name}</a></li>
				</c:when>
				<c:when test="${vo.board_use== 'N' }">
					<li class="active" ><a href="/postList?board_code=${vo.board_code}&page=1&pageSize=10" style="display: none;">${vo.board_name}</a></li>
				</c:when>
			</c:choose>			
		</c:forEach>
		
			
	</ul>
</div>
