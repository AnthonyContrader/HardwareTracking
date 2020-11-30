<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ItemDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/seaostyle.css" rel="stylesheet">
		<title>Item Request</title>
	</head>
	<body>
		<%@ include file="../css/header.jsp" %>
		
		<%
				
				String fiscalCodeForLent = (String) request.getAttribute("fiscalCodeForLent");
				List<ItemDTO> list = (List<ItemDTO>) request.getAttribute("list");
			%>
		
		<div class="navbar">
		  <a href="homeuser.jsp">Home</a>
		  <a class="active" href="ItemLentServlet?mode=itemlist&fiscalCodeForLent=<%=fiscalCodeForLent%>">Request</a>
		  <a href="ItemLentServlet?mode=listforuser&fiscalCodeForLent=<%=fiscalCodeForLent%>">Return</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<div class="main">
					
		
		<br>
		
			<table>
				<tr>
					<th>Id</th>
					<th>Item</th>
					<th>Price</th>
					
				</tr>
				<%
					for (ItemDTO u : list) {
				%>
				<tr>
					<td><%=u.getId()%></td>
					<td><%=u.getName()%></td>
					<td><%=u.getPrice()%></td>
				</tr>
				<%
					}
				%>
				
				<br>
				
				<h2>Select item ID; insert your fiscal code</h2>
			</table>
			
			<form id="floatright" action="ItemLentServlet?mode=insert&fiscalCodeForLent=<%=fiscalCodeForLent %>" method="post">
		  <div class="row">
		    <div class="col-25">
		      <label for="Id">Id Item</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="user" name="Id" placeholder="Id">
		    </div>
		  </div>
		  
		  <button type="submit">Confirm</button>	
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>