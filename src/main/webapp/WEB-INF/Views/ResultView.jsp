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
<%
	ResultSet rs = (ResultSet) request.getAttribute("result");
	while (rs.next()) {
		int isPass = rs.getInt("pass");
		int result = rs.getInt("result");
		if(isPass == 1){
			out.println("통과입니다. 맞은개수는"+result+"개");
		}else {
			out.println("탈락입니다. 맞은 개수는"+result+"개");
		}
	}
%>

</body>
</html>