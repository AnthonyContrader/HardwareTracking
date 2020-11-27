<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ItemLentDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="css/seastyle.css" rel="stylesheet">
		<title>Item tracker</title>
	</head>
	<body>
		<%@ include file="../css/header.jsp" %>

		<div class="navbar">
				  <a href="homeuser.jsp">Home</a>
				  <a href="ItemLentServlet?mode=itemlist">Request</a>
				  <a class="active" href="insertfiscalcode.jsp">Return</a>
				  <a href="LogoutServlet" id="logout">Logout</a>
				</div>
		<div class="main">
			
			<br>
			
			<h2>Please enter your fiscal code</h2>
			
			<br>
			
		 <form id="floatmiddle" action="ItemLentServlet?mode=listforuser" method="post">
			  <div class="row">
			    <div class="col-25">
			      <label for="Your Fiscal Code">Fiscal Code</label>
			    </div>
			    <div class="col-75">
			      <input type="text" id="user" name="fiscalCodeForLent" placeholder="Your Fiscal Code">
			    </div>
			  </div>
			  <button type="submit">Confirm</button>
		  </form>
	  		
	  	</div>
	  	<%@ include file="css/footer.jsp" %>
	</body>
  
</html>