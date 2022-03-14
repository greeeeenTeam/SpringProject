<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
</head>
<body>
	<h1>문제 추가 페이지</h1>
	<form method="post">
		<div class="form-group">
		   <label for="exam_question">문제</label>
		   <input type="text" class="form-control" name="exam_question" id="exam_question">
		</div>
		<div class="form-group">
		   <label for="ans_1">1번 문항</label>
		   <input type="text" class="form-control" name="ans_1" id="ans_1">
		</div>
		<div class="form-group">
		   <label for="ans_1">2번 문항</label>
		   <input type="text" class="form-control" name="ans_2" id="ans_2">
		</div>
		<div class="form-group">
		   <label for="ans_1">3번 문항</label>
		   <input type="text" class="form-control" name="ans_3" id="ans_3">
		</div>
		<div class="form-group">
		   <label for="ans_1">4번 문항</label>
		   <input type="text" class="form-control" name="ans_4" id="ans_4">
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
</html>