<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="DoTest?page">
		<fieldset>
			<div>
				<h1 style="text-align:center;">Question</h1>
			</div>
   			<%
				ResultSet rs = (ResultSet)request.getAttribute("result");
   				String url = request.getRequestURL().toString();
				while (rs.next()) {
					String questionID = rs.getString("id");
					String question = rs.getString("question");
					String ex_1 = rs.getString("ex_1");
					String ex_2 = rs.getString("ex_2");
					String ex_3 = rs.getString("ex_3");
					String ex_4 = rs.getString("ex_4");
					String answer = rs.getString("answer");
					String score = rs.getString("score");
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
				<input type="hidden" name="score" value=<%= score %>>
				<input type='hidden' name='page' id='page' value='0'/>
			</div>
			<% } %>			
			</fieldset>
			<div style="text-align: center;">
				<input type="submit" value="����" onclick="alert('���� �Ϸ�:)')">
			</div>
		</form>
</body>
<script>
const urlStr = window.location.href;
const url = new URL(urlStr);
const urlParams = url.searchParams;
const page = urlParams.get('page');

window.onload = function() {
	var pageElement = document.getElementById("page");
	console.log(pageElement)
	pageElement.setAttribute("value", page)
}
</script>
</html>