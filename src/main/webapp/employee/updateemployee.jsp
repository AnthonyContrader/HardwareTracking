<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EmployeeDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/seastyle.css" rel="stylesheet">
		<title>Edit User</title>
	</head>
	<body>
		<%@ include file="../css/header.jsp" %>
		<div class="navbar">
		  <a href="homeadmin.jsp">Home</a>
		  <a href="UserServlet?mode=userlist">Users</a>
		  <a class="active" href="EmployeeServlet?mode=employeelist">Employees</a>
		  <a href="ItemServlet?mode=itemlist">Items</a>
		  <a href="ItemLentServlet?mode=itemlentlist">Track Items</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<br>
		<div class="main">
		
		<%EmployeeDTO e = (EmployeeDTO) request.getAttribute("dto");%>
		
		
		<form id="floatleft" action="EmployeeServlet?mode=update&id=<%=e.getIdFC()%>" method="post">
		  <div class="row">
		    <div class="col-25">
		      <label for="user">IDFC</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="idfc" name="idFC" value=<%=e.getIdFC()%>>
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">First Name</label>
		    </div>
		    <div class="col-75">
		      <input
					type="text" id="fname" name="firstName" value=<%=e.getFirstName()%>> 
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">Last Name</label>
		    </div>
		    <div class="col-75">
		      <input
					type="text" id="lname" name="lsdtName" value=<%=e.getLastName()%>> 
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">Salary</label>
		    </div>
		    <div class="col-75">
		      <input
					type="text" id="salary" name="salary" value=<%=e.getSalary()%>> 
		    </div>
		  </div>
		      <button type="submit" >Edit</button>
		</form>
		
			
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>	
	</body>
</html>