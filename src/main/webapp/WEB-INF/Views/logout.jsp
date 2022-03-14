<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 처리</title>
</head>
<body>
<%
session.invalidate();
out.println("<script>alert('로그아웃되었습니다'); history.back(); </script>");
response.sendRedirect("index.jsp");
%>
<!-- 로그아웃 처리 완료 -->
</body>
</html>