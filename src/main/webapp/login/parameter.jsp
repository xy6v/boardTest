<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp 기본객체 (암묵적객체, 묵시적 객체, implict object) --%>
	<%
		//인자값 : 파라미터 이름 //getParameter(String name) => name에 해당하는 파라미터의 값 반환
		request.getParameter("userId");
		request.getParameter("userPass");
		
		String[] userIds = request.getParameterValues("userId");
		
		Map<String, String[]> requestMap= request.getParameterMap();
		String [] mapUserIds = requestMap.get("userId");
		
		Enumeration enumeration = request.getParameterNames();
	%>
	
	userId : <%=request.getParameter("userId") %><br>
	userPass : <%=request.getParameter("userPass") %>
	
	<h2>getParameterValues</h2>
	<%
		for(String userId : userIds){%>
			userId : <%=userId %><br>
		<%}%>
	
	<h2>getParameterMap</h2>
	<%
		for(String userId : mapUserIds){%>
			userId : <%=userId %><br>
		<%}%>
	<h2>getParameterNames</h2>
	<%
		while(enumeration.hasMoreElements()){
			String parameterName= (String)enumeration.nextElement();
			%>
			parameterName : <%=parameterName %><br>
		<%}%>
</body>
</html>