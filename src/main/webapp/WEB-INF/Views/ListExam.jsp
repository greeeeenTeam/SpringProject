<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
</head>
<body>
	<h1>문제 목록</h1>
	<table>
		<thead>
			<tr>
				<th>index</th>
				<th>질문</th>
				<th>1번</th>
				<th>2번</th>
				<th>3번</th>
				<th>4번</th>
				<th>정답</th>
			</tr>
		</thead>
		<tbody>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("questionList");
		while(rs.next()) {
			String question = rs.getString("question");
			String ex_1 = rs.getString("ex_1");
			String ex_2 = rs.getString("ex_2");
			String ex_3 = rs.getString("ex_3");
			String ex_4 = rs.getString("ex_4");
			String answer = rs.getString("answer");
	%>
		<tr>
			<td><% out.println(question); %></td>
			<td><% out.println(ex_1); %></td>
			<td><% out.println(ex_2); %></td>
			<td><% out.println(ex_3); %></td>
			<td><% out.println(ex_4); %></td>
			<td><% out.println(answer); %></td>
		</tr>
	<%
		}
	%>
		</tbody>
	</table>
</body>
</html>