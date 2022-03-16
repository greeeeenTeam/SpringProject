<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../../nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러</title>
</head>
<body>
	<h1>이미 가입한 주민번호 입니다.</h1>
	수험번호 : <%= (String)request.getAttribute("cn") %>
</body>
</html>