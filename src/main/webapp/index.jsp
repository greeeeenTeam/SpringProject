<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<head>
		<title>메인 페이지</title>
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
					<a href="test">
						<input type = "button" value="시험보기">
					</a>
					<input type = "button" value="결과보기">
            	</div>
			</fieldset>
		</form>
	</body>