<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/board/board.jsp">게시판 생성<span
				class="sr-only">(current)</span></a></li>
		<c:forEach items="${boardList}" var="vo">
			<li class="active"><a href="/postList?board_code=${vo.board_code}&page=1&pageSize=10&board_use=Y"/>${vo.board_name}</a></li>
		</c:forEach>
	</ul>
</div>

<%-- 
					<c:forEach items="${studentList}" var="vo">
										tr태그 클릭시 상세페이지로 이동
										<tr data-id="${vo.id}">
											<td>${vo.id}</td>
											<td>${vo.name}</td>
											<td>${vo.call_cnt}</td>
											<td><fmt:formatDate value="${vo.reg_dt}"
													pattern="yyyy-MM-dd" /></td>
										</tr>
									</c:forEach> --%>