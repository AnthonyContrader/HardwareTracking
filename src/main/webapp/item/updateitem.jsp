<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ItemDTO"%>
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
		  <a href="EmployeeServlet?mode=employeelist">Employees</a>
		  <a class="active" href="ItemServlet?mode=itemlist">Items</a>
		  <a href="ItemLentServlet?mode=itemlentlist">Track Items</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<br>
		<div class="main">
		
		<%ItemDTO i = (ItemDTO) request.getAttribute("dto");%>
		
		
		<form id="floatleft" action="ItemServlet?mode=update&id=<%=i.getId()%>" method="post">
		  <div class="row">
		    <div class="col-25">
		      <label for="user">Name</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="name" name="name" value=<%=i.getName()%>>
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">Price</label>
		    </div>
		    <div class="col-75">
		      <input
					type="text" id="price" name="price" value=<%=i.getPrice()%>> 
		    </div>
		  </div>
		      <button type="submit" >Edit</button>
		</form>
		
			
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>	
	</body>
</html>