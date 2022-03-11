<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <input type="submit">
   </form>
	<%} else {%>
	<script>location.href="/SpringProject/test"; </script>
	<%} %>
</body>
</html>