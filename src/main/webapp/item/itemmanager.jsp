<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ItemDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/seastyle.css" rel="stylesheet">
		<title>User Manager</title>
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
		<div class="main">
			<%
				List<ItemDTO> list = (List<ItemDTO>) request.getAttribute("list");
			%>
		
		<br>
		
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th colspan="2">Actions</th>
				</tr>
				<%
					for (ItemDTO i : list) {
				%>
				<tr>
					<td><a href=ItemServlet?mode=read&id=<%=i.getId()%>>
							<%=i.getId()%>
					</a></td>
					<td><%=i.getName()%></td>
					<td><%=i.getPrice()%></td>
					<td><a href=ItemServlet?mode=read&update=true&id=<%=i.getId()%>>Edit</a>
					</td>
					<td><a href=ItemServlet?mode=delete&id=<%=i.getId()%>>Delete</a>
					</td>
		
				</tr>
				<%
					}
				%>
			</table>
		
		
		
		<form id="floatright" action="ItemServlet?mode=insert" method="post">
		  <div class="row">
		    <div class="col-25">
		      <label for="name">Name</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="name" name="name" placeholder="Insert Name">
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">Price</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="price" name="price" placeholder="Insert Price"> 
		    </div>
		  </div>
		      <button type="submit" >Insert</button>
		</form>
		
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>