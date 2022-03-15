<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<jsp:include page="nav.jsp"/> 
	<head>
		<title>메인 페이지</title>
			<style>
				fieldset{
					width:100%;
					height:100%;
					border:none;	
				}
				.container {
					
					margin: 0 auto;
				}
				.btnContainer {
				 	margin-top: 20px;
				}
				.title {
					margin-top: 20px;
				}
				#createAccount {
					width: 200px;
					height: 60px;
					background-color: black;
					color: white;
					font-size: 20px;
					font-weight: bold;
					margin-right: 10px;
				}
				#takeExam {
					width: 200px;
					height: 60px;
					background-color: black;
					color: white;
					font-size: 20px;
					font-weight: bold;
					margin-left: 10px;
				}
			</style>
	</head>

	<body>
		<%-- <%=new Date()%> <!-- 웹이 refresh되었는지 확인하기위한 용도  --> --%>
		<div class="container">
		<form>
			<fieldset>
				<div class="title">
					<h1 style="text-align:center;">동기愛 테스트</h1>
				</div>
				<div style="text-align:center;">
					<img src="https://image.zdnet.co.kr/2020/12/29/865ab83c58f41968b5b066453c03388b.png" border="3" style="width : 700px; height: 500px;">
				</div>
				<div style="text-align:center;" class="btnContainer">
					<a href="signup">
						<input type = "button" id="createAccount" value="계정생성">
					</a>
					<a href="cnlogin">
						<input type = "button" id="takeExam" value="시험보기">
					</a>
            	</div>
			</fieldset>
		</form>
		</div>
		
	</body>