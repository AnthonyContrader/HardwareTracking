<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String myDate = new java.util.Date().toString();
	String currentYear = myDate.substring(23);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="css/seastyle.css" rel="stylesheet">
	</head>
	<body>
		<div class="footer">
			<h3 id="floatleft">Designed by SEA Team</h3>
			<h3 id="floatright">Contrader - <%= currentYear %></h3>
			<div style="clear: both;"></div>
		</div>
	</body>
</html>