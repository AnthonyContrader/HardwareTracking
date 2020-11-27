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
		
		<div class="navbar">
		  <a href="homeuser.jsp">Home</a>
		  <a class="active" href="ItemLentServlet?mode=itemlist">Request</a>
		  <a href="insertfiscalcode.jsp">Return</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<div class="main">
					<%
				List<ItemDTO> list = (List<ItemDTO>) request.getAttribute("list");
			%>
		
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
			
			<form id="floatright" action="ItemLentServlet?mode=insert" method="post">
		  <div class="row">
		    <div class="col-25">
		      <label for="Id">Id Item</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="user" name="Id" placeholder="Id">
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-25">
		     <label for="pass">Fiscal Code</label>
		    </div>
		    <div class="col-75">
		      <input type="text" id="idfc" name="fiscalCodeForLent" placeholder="Insert your fiscal code"> 
		    </div>
		  </div>
		  
		  <button type="submit">Confirm</button>	
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>