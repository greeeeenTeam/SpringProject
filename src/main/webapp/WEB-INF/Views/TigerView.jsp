<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>여기는 TigerView</h3>
	<h3>${name} ${age}</h3>
	<%-- <%
		// String nn = request.getParameter("name");
		String nn =(String)request.getAttribute("name");
		String aa =(String)request.getAttribute("age");
	%>
	<%=nn %>
	<%=aa %> --%>
</body>
</html>