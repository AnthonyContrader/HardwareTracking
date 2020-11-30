<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.ItemLentDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home User</title>
		<link href="css/seastyle.css" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
	</head>
	<body>
		<%@include file="css/header.jsp"%>
		
		<h1 class="up">Welcome ${user.getUsername().toUpperCase()}</h1>
		
		<%
 		
			String fiscalCodeForLent = (String) request.getAttribute("fiscalCodeForLent");
		 ItemLentDTO item = (ItemLentDTO) request.getAttribute("esito");
		
			if(item != null) {
			
			try{
		
				%>
				<script type="text/javascript">
				    alert("Your request have been forward!");
				</script>
				<%
				    }catch(Exception e){
		
				    }
			
		}
			
			
		%>
		
		<div class="navbar">
		  <a class="active" href="homeuser.jsp">Home</a>
		  <a href="ItemLentServlet?mode=itemlist&fiscalCodeForLent=<%=fiscalCodeForLent%>">Request</a>
		  <a href="ItemLentServlet?mode=listforuser&fiscalCodeForLent=<%=fiscalCodeForLent%>">Return</a>
		  <a href="LogoutServlet" id="logout">Logout</a>
		</div>
		
		<div class="principal">
		
			<div id="floatmiddle">
				<!-- Request's Card -->
				<div id="floatleft" class="card">
					<a href="ItemLentServlet?mode=itemlist&fiscalCodeForLent=<%=fiscalCodeForLent%>">
				    	<div class="card-body">
					   		<i class="fas fa-exchange-alt"style="color: #166e07;"></i>
					   		<h3 class="card-title">Request</h3>
					   		<p class="card-text">Access this page in order to be able to Request items.</p>
					 	</div>
				 	</a>
				</div>
				
				<!-- Return's Card -->
				<div id="floatleft" class="card space">
					<a href="ItemLentServlet?mode=listforuser&fiscalCodeForLent=<%=fiscalCodeForLent%>">
				    	<div class="card-body">
					   		<i class="fas fa-undo-alt" style="color: #0b18a3;"></i>
					   		<h3 class="card-title">Return</h3>
					   		<p class="card-text">Access this page in order to be able to Return items.</p>
					 	</div>
				 	</a>
				</div>
			</div>
		
		</div>
		
		
		<%@ include file="css/footer.jsp" %>
		
	</body>
</html>