<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home Admin</title>
		<link href="css/seastyle.css" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
		<link rel="icon" href="img/favicon.ico" type="image/x-icon">
		<style>body {overflow-x: hidden;}</style>
	</head>
	<body>
		<%@include file="css/header.jsp"%>
		
		<h1 class="up">Welcome ${user.getUsername().toUpperCase()}</h1>
		
		<div class="navbar">
		  <a class="active" href="homeadmin.jsp">Home</a>
		  <a href="UserServlet?mode=userlist">Users</a>
		  <a href="EmployeeServlet?mode=employeelist">Employees</a>
		  <a href="ItemServlet?mode=itemlist">Items</a>
		  <a href="ItemLentServlet?mode=itemlentlist">Track Items</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		
		<div class="principal">
			<!-- User's Card -->
			<div id="floatleft" class="card">
				<a href="UserServlet?mode=userlist">
			    	<div class="card-body">
				   		<i class="fas fa-users" style="color: orange;"></i>
				   		<h3 class="card-title">Users</h3>
				   		<p class="card-text">Access this page in order to be able to execute the CRUD options for Users. (Create, Read, Update, Delete)</p>
				 	</div>
			 	</a>
			</div>
			
			<!-- Employee's Card -->
			<div id="floatleft" class="card space">
				<a href="EmployeeServlet?mode=employeelist">
			    	<div class="card-body">
				   		<i class="fas fa-address-card" style="color: #1bd140;"></i>
				   		<h3 class="card-title">Employees</h3>
				   		<p class="card-text">Access this page in order to be able to execute the CRUD options for Employees. (Create, Read, Update, Delete)</p>
				 	</div>
			 	</a>
			</div>
			
			<!-- Item's Card -->
			<div id="floatleft" class="card space">
				<a href="ItemServlet?mode=itemlist">
			    	<div class="card-body">
				   		<i class="fas fa-book" style="color: #1bc8d1;"></i>
				   		<h3 class="card-title">Items</h3>
				   		<p class="card-text">Access this page in order to be able to execute the CRUD options for Items. (Create, Read, Update, Delete)</p>
				 	</div>
			 	</a>
			</div>
			
			<!-- Item's Tracking Card -->
			<div id="floatleft" class="card space">
				<a href="ItemLentServlet?mode=itemlentlist">
			    	<div class="card-body">
				   		<i class="fas fa-chalkboard" style="color: #d11b1b;"></i>
				   		<h3 class="card-title">Items Tracking</h3>
				   		<p class="card-text">Access this page in order to be able to execute the CRUD options for Items Tracking. (Create, Read, Update, Delete)</p>
				 	</div>
			 	</a>
			</div>
			
		</div><div style="clear: both;"></div>
		
		
		<%@ include file="css/footer.jsp" %>
		
	</body>
</html>