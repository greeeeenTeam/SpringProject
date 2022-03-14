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
	<h1>문제 수정 페이지</h1>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("exam");
		rs.next();
		String ex_id = rs.getString("id");
		String question = rs.getString("question");
		String ex_1 = rs.getString("ex_1");
		String ex_2 = rs.getString("ex_2");
		String ex_3 = rs.getString("ex_3");
		String ex_4 = rs.getString("ex_4");
		String answer = rs.getString("answer");
	%>
	<form method="post">
		<div class="form-group" style="display:none">
		   <label for="ex_id">ID</label>
		   <input type="text" class="form-control" name="ex_id" id="ex_id" value="<%= ex_id %>">
		</div>
		<div class="form-group">
		   <label for="exam_question">문제</label>
		   <input type="text" class="form-control" name="exam_question" id="exam_question" value="<%= question %>">
		</div>
		<div class="form-group">
		   <label for="ans_1">1번 문항</label>
		   <input type="text" class="form-control" name="ans_1" id="ans_1" value="<%= ex_1 %>">
		</div>
		<div class="form-group">
		   <label for="ans_1">2번 문항</label>
		   <input type="text" class="form-control" name="ans_2" id="ans_2" value="<%= ex_2 %>">
		</div>
		<div class="form-group">
		   <label for="ans_1">3번 문항</label>
		   <input type="text" class="form-control" name="ans_3" id="ans_3" value="<%= ex_3 %>">
		</div>
		<div class="form-group">
		   <label for="ans_1">4번 문항</label>
		   <input type="text" class="form-control" name="ans_4" id="ans_4" value="<%= ex_4 %>">
		</div>
		<div class="form-group">
		   <label for="answer">정답</label>
		   <select id="answer" name="answer">
		     <option value="1">1</option>
		     <option value="2">2</option>
		     <option value="3">3</option>
		     <option value="4">4</option>
		   </select>
		</div>
		<button type="submit">제출</button>
	</form>
</body>
<script>
	var answer = document.getElementById("answer");
	answer.options[<%= answer %> - 1].selected = true;
</script>
</html>