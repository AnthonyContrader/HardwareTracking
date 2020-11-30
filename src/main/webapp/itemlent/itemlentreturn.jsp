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
		
		
		<%		
				String fiscalCodeForLent = (String) request.getAttribute("fiscalCodeForLent");
				List<ItemLentDTO> list = (List<ItemLentDTO>) request.getAttribute("listforuser");
			%>
		
		<div class="navbar">
		  <a href="homeuser.jsp">Home</a>
		  <a href="ItemLentServlet?mode=itemlist&fiscalCodeForLent=<%=fiscalCodeForLent%>">Request</a>
		  <a class="active" href="ItemLentServlet?mode=listforuser&fiscalCodeForLent=<%=fiscalCodeForLent%>">Return</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<div class="main">
			
	
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
						<td><a href="ItemLentServlet?mode=delete&mix=<%=u.getId()+"-"+fiscalCodeForLent%>"><%=u.getId()%></a></td>
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