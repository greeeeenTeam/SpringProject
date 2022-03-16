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
<form id="theForm" action="DoTest?page">
		<fieldset>
			<div>
				<h1 style="text-align:center;">Question</h1>
			</div>
   			<%
				ResultSet rs = (ResultSet)request.getAttribute("result");
   				String url = request.getRequestURL().toString();
				while (rs.next()) {
					String questionID = rs.getString("id");
					String question = rs.getString("question");
					String ex_1 = rs.getString("ex_1");
					String ex_2 = rs.getString("ex_2");
					String ex_3 = rs.getString("ex_3");
					String ex_4 = rs.getString("ex_4");
					String answer = rs.getString("answer");
					String score = rs.getString("score");
			%>

			<div class="card">
				<div><%=question %></div>
				<label><input type="radio" name="answer"
					value="1"> <% out.println(ex_1); %></label> 
					
				<label><input type="radio" name="answer"
					value="2"> <% out.println(ex_2); %></label>
	
				<label><input type="radio" name="answer"
					value="3"> <% out.println(ex_3); %></label> 
	
				<label><input type="radio" name="answer"
					value="4"> <% out.println(ex_4); %></label>
				<input type="hidden" name="checkAnswer" value=<%= answer %>>
				<input type="hidden" name="score" value=<%= score %>>
				<input type='hidden' name='page' id='page' value='0'/>
			</div>
			<% } %>			
			</fieldset>
			<div style="text-align: center;">
				<input type="submit" value="제출" onclick="alert('제출완료')">
			</div>
		</form>
		<div class="countdown">00:00:00</div>
<hr/>
</body>
<script>
const urlStr = window.location.href;
const url = new URL(urlStr);
const urlParams = url.searchParams;
const page = urlParams.get('page');

window.onload = function() {
	var pageElement = document.getElementById("page");
	console.log(pageElement)
	pageElement.setAttribute("value", page)
}
var tmhandler;
/* Timer */
function countdown( className, seconds ){
        var element, endTime, hours, mins, secs, msLeft, time;
       
        function updateTimer(){
               msLeft = endTime - (+new Date);
               if ( msLeft < 0 ) {
                   document.getElementById('theForm').submit();
               } else {
                       time = new Date( msLeft );
                      
                       hours = ('0' + time.getUTCHours()).slice(-2);
                       mins  = ('0' + time.getUTCMinutes()).slice(-2);
                       secs  = ('0' + time.getUTCSeconds()).slice(-2);
                       element.innerHTML = hours + ':' + mins + ':' + secs;
                       tmhandler = setTimeout( updateTimer, time.getUTCMilliseconds());
               }
        }
       
        element = document.getElementsByClassName(className);
        if(element.length!=0) {
               element = element[0];
               endTime = (+new Date) + 3000 * seconds;
               updateTimer();
        } else {
               alert("no timer");
        }
}
countdown('countdown', 10);  // seconds
</script>
</html>