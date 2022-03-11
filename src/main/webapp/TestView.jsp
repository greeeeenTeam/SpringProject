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
				<div style="text-align:center;">
					<label><input type="radio" name="lecture" value="Question1">
               Q1</label> <br>
				</div>
				<div style="text-align:center;">
					<label><input type="radio" name="lecture" value="Question2">
               Q2</label> <br>
				</div>
				<div style="text-align:center;">
					<label><input type="radio" name="lecture" value="Question3">
               Q3</label> <br>
				</div>
				<div style="text-align:center;">
					<label><input type="radio" name="lecture" value="Question4">
               Q4</label> <br>
				</div>
				<div style="text-align:center;">
					<input type="submit" value="제출" onclick="alert('제출 완료:)')">
               	</div>
			
			</fieldset>
		</form>
	</body>
</html>