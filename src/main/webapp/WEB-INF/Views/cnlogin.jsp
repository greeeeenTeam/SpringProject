<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>시험 시작</title>
</head>
<body>
   <% if(session.getAttribute("cn")==null) { %>
   <form method="post">
      <label for="user_name">수험자 이름</label>
      <input type="text" name="user_name">
      <label for="user_cn">수험자 수험번호</label>
      <input type="text" name="user_cn">
      <input type="submit" value="입장">
      <a href="findcn"> <input  type="button" value="수험번호찾기"></a>
      <a href="result">
      </a>
   </form>
	<%} else {%>
		<script>location.href="/SpringProject/wait"; </script>
	<%} %>
</body>
</html>