<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="DoTest">
		<fieldset>
			<div>
				<h1 style="text-align:center;">Question</h1>
			</div>
   			<%
				ResultSet rs = (ResultSet)request.getAttribute("result");
				while (rs.next()) {
					String questionID = rs.getString("id");
					String question = rs.getString("question");
					String ex_1 = rs.getString("ex_1");
					String ex_2 = rs.getString("ex_2");
					String ex_3 = rs.getString("ex_3");
					String ex_4 = rs.getString("ex_4");
					String answer = rs.getString("answer");
			%>

			<div class="card">
				<div><%=question %></div>
				<label><input type="radio" name="answer"
					value="1"> <% out.println(ex_1); %></label> 
					
				<label><input type="radio" name="answer"
					value="2"> <% out.println(ex_2); %></label>
	
				<label><input type="radio" name="answer"
					value="3"> <% out.println(ex_3); %></label> 
	
				<label><input type="radio" name="answer"
					value="4"> <% out.println(ex_4); %></label>
				<input type="hidden" name="checkAnswer" value=<%= answer %>>
			</div>
			<% } %>			
			</fieldset>
			<div style="text-align: center;">
				<input type="submit" value="제출" onclick="alert('제출 완료:)')">
			</div>
		</form>
</body>
<script>

</script>
</html>