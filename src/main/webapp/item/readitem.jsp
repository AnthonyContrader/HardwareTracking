<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ItemDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/seastyle.css" rel="stylesheet">
		<title>Read User</title>
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
		
		
		<table>
			<tr> 
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<tr>
				<td><%=i.getId()%></td>
				<td> <%=i.getName()%></td>
				<td> <%=i.getPrice()%></td>
			</tr>	
		</table>
		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		
		</div>
		
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>