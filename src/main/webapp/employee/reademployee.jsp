<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EmployeeDTO"%>
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
		    <a class="active" href="EmployeeServlet?mode=employeelist">Employees</a>
		    <a href="ItemServlet?mode=itemlist">Items</a>
		    <a href="ItemLentServlet?mode=itemlentlist">Track Items</a>
			<a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<br>
		
		<div class="main">
		<%EmployeeDTO e = (EmployeeDTO) request.getAttribute("dto");%>
		
		
		<table>
			<tr> 
				<th>IDFC</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Salary</th>
			</tr>
			<tr>
				<td><%=e.getIdFC()%></td>
				<td> <%=e.getFirstName()%></td>
				<td> <%=e.getLastName()%></td>
				<td> <%=e.getSalary()%></td>
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