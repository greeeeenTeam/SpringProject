<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("error")==null) { %>
	<h1>로그인 완료</h1>
	<a href="/SpringProject/test">
		<button>시험응시</button>
	</a>
	<a href="/SpringProject/directResult">
		<button>결과보기</button>
	</a>
	<% } else { %>
	<h1>로그인 실패</h1>
	<p><%= session.getAttribute("error") %></p>
	<a href="/SpringProject/logout">
		<button>돌아가기</button>
	</a>

	<% } %>
</body>
</html>