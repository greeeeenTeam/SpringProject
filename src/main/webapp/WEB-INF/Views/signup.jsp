<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
   <form method="post">
      <label for="user_name">수험자 이름👀</label>
      <input placeholder="ex: ○○○" type="text" name="user_name">
      <label for="user_rrn">수험자 생년월일🎉<label>
      <input placeholder="ex: 220314" maxlength="6" type="text" name="user_rrn">
      <input type="submit">
   </form>
</body>
</html>