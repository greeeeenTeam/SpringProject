<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	<h1>동기애 테스트 문제지<h1>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("questionList");
		while (rs.next()) {
			String question = rs.getString("question");
			String ex_1 = rs.getString("ex_1");
			String ex_2 = rs.getString("ex_2");
			String ex_3 = rs.getString("ex_3");
			String ex_4 = rs.getString("ex_4");
			String answer = rs.getString("answer");
			out.println(question);
			out.println(ex_1);
			out.println(ex_2);
			out.println(ex_3);
			out.println(ex_4);
		}
	%>
</body>
</html>