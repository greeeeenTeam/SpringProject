<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../../nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	text-align:center;
	margin-top: 200px;
}
</style>
</head>
<body>
	<h1>
		수험번호 : <%= (String)request.getAttribute("cn") %>
	</h1>
</body>

</html>