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
	<form action="DoTest">
			<fieldset>
				<div>
					<h1 style="text-align:center;">Question</h1>
				</div>
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
	%>
			<% out.println(question); %>
	
	<div style="text-align:center;">
					<label><input type="radio" name="Answer1" value="Question1">
               <% out.println(ex_1); %></label> <br>
				</div>
				<div style="text-align:center;">
					<label><input type="radio" name="Answer2" value="Question2">
               <% out.println(ex_2); %></label> <br>
				</div>
				<div style="text-align:center;">
					<label><input type="radio" name="Answer3" value="Question3">
               <% out.println(ex_3); %></label> <br>
				</div>
				<div style="text-align:center;">
					<label><input type="radio" name="Answer4" value="Question4">
               <% out.println(ex_4); %></label> <br>
				</div>
				<div style="text-align:center;">
					<input type="submit" value="제출" onclick="alert('제출 완료:)')">
               	</div>
	
	<% 	}
	%>

			</fieldset>
		</form>
	
</body>
</html>