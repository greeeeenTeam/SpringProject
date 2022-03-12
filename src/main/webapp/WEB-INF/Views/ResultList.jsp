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
	<h1>시험 응시 결과 목록</h1>
	<table>
		<thead>
		<tr>
			<th>index</th>
			<th>응시번호</th>
			<th>맞춘 문제 수</th>
			<th>통과 여부</th>
		</tr>
		</thead>
		<tbody>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("resultList");
		while(rs.next()) {
			String question = rs.getString("id");
			String cn = rs.getString("cn");
			String pass = rs.getString("pass");
			String result = rs.getString("result");
	%>
		<tr>
			<td><% out.println(question); %></td>
			<td><% out.println(cn); %></td>
			<td><% out.println(pass); %></td>
			<td><% out.println(result); %></td>
		</tr>
	<%
		}
	%>
		</tbody>
	</table>
</body>
</html>