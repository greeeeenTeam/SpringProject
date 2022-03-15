<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
    />
<title>Insert title here</title>
<style>
	@import url("https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap");

@font-face {
  font-family: AstroSpace;
  src: url(/fonts/AstroSpace.ttf);
}

body {
  margin: 0;
  padding: 0;
  font-family: "Montserrat", sans-serif;
}

header {
  background-color: #141b25;
}

.main-nav {
  height: 90px;
}

.logo {
  color: white;
  line-height: 90px;
  font-size: 30px;
  font-weight: bold;
  text-decoration: none;
  margin-left: 30px;
  font-family: "AstroSpace", sans-serif;
}

.navlinks {
  list-style: none;
  float: right;
  line-height: 90px;
  margin: 0;
  padding: 0;
}

.navlinks li {
  display: inline-block;
  margin: 0px 20px;
}

.navlinks li a {
  color: white;
  text-decoration: none;
  font-size: 18px;
  transition: all 0.3s linear 0s;
  text-transform: uppercase;
}

.navlinks li a:hover {
  color: #7ebcb9;
  padding-bottom: 7px;
  border-bottom: 2px solid #7ebcb9;
}

li a.contact {
  background-color: #00adb5;
  padding: 9px 20px;
  border-radius: 50px;
  transition: all 0.3s ease 0s;
  border-bottom: none;
}

li a.contact:hover {
  background-color: #047e85;
  color: white;
  border-bottom: none;
}

#check {
  display: none;
}

.menu-btn {
  font-size: 25px;
  color: white;
  float: right;
  line-height: 90px;
  margin-right: 40px;
  display: none;
  cursor: pointer;
}

@media (max-width: 800px) {
  .navlinks {
    position: fixed;
    width: 100%;
    height: 100vh;
    text-align: center;
    transition: all 0.5s;
    right: -100%;
    background: #222831;
  }

  .navlinks li {
    display: block;
  }

  .navlinks li a {
    font-size: 20px;
    font-weight: bold;
  }

  .navlinks li a:hover {
    border-bottom: none;
  }

  .menu-btn {
    display: block;
  }

  #check:checked ~ .navlinks {
    right: 0;
  }
}
</style>
</head>
<body>
<!-- 	<a href="/SpringProject/logout">
		<input type = "button" value="로그아웃">
	</a>
	<a href="main">
		<input type = "button" value="홈으로">
	</a>
	<a href="javascript:history.back()">
		<input type = "button" value="뒤로가기">
	</a> -->
	
	<header>
      <nav class="main-nav">
        <input type="checkbox" id="check" />
        <label for="check" class="menu-btn">
          <i class="fas fa-bars"></i>
        </label>
        <a href="main" class="logo">愛</a>
        <ul class="navlinks">
          <li><a href="/SpringProject/logout">로그아웃</a></li>
          <li><a href="main">홈으로</a></li>
          <li><a href="javascript:history.back()">뒤로가기</a></li>
        </ul>
      </nav>
    </header>
</body>
</html>