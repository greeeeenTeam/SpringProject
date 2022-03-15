<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>어어어어아아앙 귀찮아</h1>

	<div class="container">
  <h1 id="headline">Countdown to my birthday</h1>
  <div id="countdown">
    <ul>
      <li><span id="days"></span>days</li>
      <li><span id="hours"></span>Hours</li>
      <li><span id="minutes"></span>Minutes</li>
      <li><span id="seconds"></span>Seconds</li>
    </ul>
  </div>
  <div id="content" class="emoji">
    <span>🥳</span>
    <span>🎉</span>
    <span>🎂</span>
  </div>
</div>
</body>
<script>
(function () {
	  const second = 1000,
	        minute = second * 60,
	        hour = minute * 60,
	        day = hour * 24;

	  //I'm adding this section so I don't have to keep updating this pen every year :-)
	  //remove this if you don't need it
	  let today = new Date(),
	      hh = String(today.getHours())
	      minutes = String(today.getMinutes())
	      ss = String(today.getSeconds())
	      dd = String(today.getDate()).padStart(2, "0"),
	      mm = String(today.getMonth() + 1).padStart(2, "0"),
	      yyyy = today.getFullYear(),
	      nextYear = yyyy + 1,
	      dayMonth = "09/30/",
	      birthday = dayMonth + yyyy;
	  
	  console.log(today)
	  let date2 = new Date()
	  today = mm + "/" + dd + "/" + yyyy;
	  console.log(typeof(today))
	  console.log("")
	  if (today > birthday) {
	    birthday = dayMonth + nextYear;
	  }
	  //end
	  
	  const countDown = new Date(birthday).getTime(),
	      x = setInterval(function() {    

	        const now = new Date().getTime(),
	              distance = countDown - now;

	        document.getElementById("days").innerText = Math.floor(distance / (day)),
	          document.getElementById("hours").innerText = Math.floor((distance % (day)) / (hour)),
	          document.getElementById("minutes").innerText = Math.floor((distance % (hour)) / (minute)),
	          document.getElementById("seconds").innerText = Math.floor((distance % (minute)) / second);

	        //do something later when date is reached
	        if (distance < 0) {
	          document.getElementById("headline").innerText = "It's my birthday!";
	          document.getElementById("countdown").style.display = "none";
	          document.getElementById("content").style.display = "block";
	          clearInterval(x);
	        }
	        //seconds
	      }, 0)
	  }());
</script>
</html>