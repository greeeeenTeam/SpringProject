<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>

<head>
<title>메인 페이지</title>
<style>
.test-button{
	background-color: #ffffff;
	width: 100px;
	display: block;
	margin-left:10px; 
	margin-top:30px;
	height: 70px;
	line-height: 70px;
	color: #0020f0;
	font-size: 16px;
	font-weight: 700;
}
</style>
</head>

	<body>
		<%=new Date()%> <!-- 웹이 refresh되었는지 확인하기위한 용도  -->
		<form>
			<fieldset>
				<div>
					<h1 style="text-align:center;">동기愛 테스트</h1>
				</div>
				<div style="text-align:center;">
					<img src="https://image.zdnet.co.kr/2020/12/29/865ab83c58f41968b5b066453c03388b.png" border="3" style="width : 700px; height: 500px;">
				</div>
				<div style="text-align:center;">
					<a href="signup">
						<input type = "button" value="계정생성">
					</a>
					<a href="cnlogin">
						<input type = "button" value="시험보기">
					</a>
					<a href="result">
						<input type = "button" value="결과보기">
					</a>

            	</div>
			</fieldset>
		</form>
	</body>