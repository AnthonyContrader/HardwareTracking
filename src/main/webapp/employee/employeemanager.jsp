<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EmployeeDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/seastyle.css" rel="stylesheet">
		<title>Employee Manager</title>
	</head>
	<body>
		<%@ include file="../css/header.jsp" %>
		
		<div class="navbar">
		    <a  href="homeadmin.jsp">Home</a>
		    <a href="UserServlet?mode=userlist">Users</a>
		    <a class="active" href="EmployeeServlet?mode=employeelist">Employees</a>
			<a href="ItemServlet?mode=itemlist">Items</a>
			<a href="ItemLentServlet?mode=itemlentlist">Track Items</a>
		    <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<div class="main">
			<%
				List<EmployeeDTO> list = (List<EmployeeDTO>) request.getAttribute("list");
			%>
		
		<br>
		
			<table>
				<tr>
					<th>IDFC</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Salary</th>
					<th colspan="2">Actions</th>
				</tr>
				<%
					for (EmployeeDTO e : list) {
				%>
				<tr>
					<td><a href=EmployeeServlet?mode=read&idFC=<%=e.getIdFC()%>>
							<%=e.getIdFC()%>
					</a></td>
					<td><%=e.getFirstName()%></td>
					<td><%=e.getLastName()%></td>
					<td><%=e.getSalary()%></td>
					<td><a href=EmployeeServlet?mode=read&update=true&idFC=<%=e.getIdFC()%>>Edit</a>
					</td>
					<td><a href=EmployeeServlet?mode=delete&idFC=<%=e.getIdFC()%>>Delete</a>
					</td>
		
				</tr>
				<%
					}
				%>
			</table>
		
		
		<form id="floatright" action="EmployeeServlet?mode=insert" method="post">
		  <div class="row">
		    <div class="col-25">
		      <label for="idfc">IDFC</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="idfc" name="idFC" placeholder="Insert the Fiscal Code">
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">First Name</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="fname" name="firstName" placeholder="Insert First Name"> 
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">Last Name</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="lname" name="lastName" placeholder="Insert Last Name"> 
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">Salary</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="salary" name="salary" placeholder="Insert Salary"> 
		    </div>
		  </div>
		      <button type="submit" >Insert</button>
		</form>
		
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>