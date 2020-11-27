<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ItemLentDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/seaostyle.css" rel="stylesheet">
		<title>Item Lent Manager</title>
	</head>
	<body>
		<%@ include file="../css/header.jsp" %>
		
		<div class="navbar">
		    <a href="homeadmin.jsp">Home</a>
		    <a href="UserServlet?mode=userlist">Users</a>
		    <a href="EmployeeServlet?mode=employeelist">Employees</a>
		    <a href="ItemServlet?mode=itemlist">Items</a>
		    <a class="active" href="ItemLentServlet?mode=itemlentlist">Track Items</a>
		    <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<div class="main">
			<%
				List<ItemLentDTO> list = (List<ItemLentDTO>) request.getAttribute("list");
			%>
		
		<br>
		
		<div id="floatmiddle">
			<table>
				<tr>
					<th>ID</th>
					<th>Product</th>
					<th>Owner's First Name</th>
					<th>Owner's Last Name</th>
					<th>Fiscal Code</th>
				</tr>
				<%
					for (ItemLentDTO il : list) {
				%>
				<tr>
					<td><a href=UserServlet?mode=read&id=<%=il.getId()%>>
							<%=il.getId()%>
					</a></td>
					<td><%=il.getItemName()%></td>
					<td><%=il.getFirstNameOwner()%></td>
					<td><%=il.getLastNameOwner()%></td>
					<td><%=il.getFiscalCodeForLent()%></td>
		
				</tr>
				<%
					}
				%>
			</table>
		</div>
		
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>