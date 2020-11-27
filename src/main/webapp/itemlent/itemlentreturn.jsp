<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ItemLentDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/seaostyle.css" rel="stylesheet">
		<title>Item Tracker</title>
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
			
			<%
				List<ItemLentDTO> list = (List<ItemLentDTO>) request.getAttribute("listforuser");
			%>
	
			<br>
		
			<h2>Click on the ID to return item</h2>
		
			<div id="floatmiddle" style="padding-left: 275px;">
				
				<table>
					<tr>
						<th>Id</th>
						<th>Item</th>
						<th>Price</th>
						
					</tr>
					<%
						for (ItemLentDTO u : list) {
					%>
					<tr>
						<td><a href=ItemLentServlet?mode=delete&id=<%=u.getId()%>><%=u.getId()%></a></td>
						<td><%=u.getItemName()%></td>
						<td><%=u.getPrice()%></td>
					</tr>
					<%
						}
					%>
					
					<br>
					
				</table>
			</div>
			
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>