<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
 #q1, #q2, #q3, #q4, #q5 {
 	display: none;
 }
</style> -->
<!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.3.0/js/mdb.min.js"></script>
	<link rel="stylesheet" type="text/css" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.3.0/css/mdb.min.css">
</head>
	<body>
	<nav>
	    <ul class="pagination pg-red">

	        <!--Numbers-->
	        <li class="page-item"><a class="page-link">1</a></li>
	        <li class="page-item"><a class="page-link">2</a></li>
	        <li class="page-item"><a class="page-link">3</a></li>
	        <li class="page-item"><a class="page-link">4</a></li>
			<li class="page-item"><a class="page-link">5</a></li>
	    </ul>
	</nav>
	<!--/Pagination red-->
	
	 <script type="text/javascript">
    	$(document).ready(function(){
            
    		//Hide all cards
    		$(".card").each(function(index, value){
    			$('.card').hide();
    		})
            

    		$(".page-link").on('click', function(){
                
    			$(".page-link").each(function(index, value){
    				$(value).parent().removeClass("active");
    			});

    			//Hide all cards
	    		$(".card").each(function(index, value){
	    			$('.card').hide();
	    		})
  
    			$(this).parent().addClass("active");
    			var cardId = "#" + $(this).text();
    			$(cardId).show();
    		});

    	});
    </script>
    	<form action="DoTest">
		<fieldset>
			<div>
				<h1 style="text-align:center;">Question</h1>
			</div>
   			<%
				ResultSet rs = (ResultSet) request.getAttribute("questionList");
   				int idx = 1;
				while (rs.next()) {
					String question = rs.getString("question");
					String ex_1 = rs.getString("ex_1");
					String ex_2 = rs.getString("ex_2");
					String ex_3 = rs.getString("ex_3");
					String ex_4 = rs.getString("ex_4");
					String answer = rs.getString("answer");
			%>

			<div id="<%= idx%>" class="card">
				<div><%=question %></div>
				<label><input type="radio" name="answer<%= idx%>"
					value="1"> <% out.println(ex_1); %></label> 
					
				<label><input type="radio" name="answer<%= idx%>"
					value="2"> <% out.println(ex_2); %></label>
	
				<label><input type="radio" name="answer<%= idx%>"
					value="3"> <% out.println(ex_3); %></label> 
	
				<label><input type="radio" name="answer<%= idx%>"
					value="4"> <% out.println(ex_4); %></label>
				<input type="hidden" name="checkAnswer" value=<%=answer %>>
				<%if (idx <5){ %>
				<div style="text-align: center;">
					<input type="hidden" value="제출" onclick="alert('제출 완료:)')">
				</div>
				<%}else { %>
				<div style="text-align: center;">
					<input type="submit" value="제출" onclick="alert('제출 완료:)')">
				</div>
				<%} %>
			</div>
			<% idx++;}idx =1;%>
			
			</fieldset>
		</form>
</body>
</html>