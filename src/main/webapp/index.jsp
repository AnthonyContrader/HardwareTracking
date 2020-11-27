<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
	<head>
		<link href="css/seastyle.css" rel="stylesheet">
		
		<title>Login SAMPLE</title>
		<style>
		body {
			
		}</style>
	</head>
<body>

	<form class="login" action="LoginServlet" method="post">

		<img alt="contrader" src="img/logo.png" width="100%" height="auto">

		<label for="user" class="login-text">Username: </label>
			
		<input type="text" id="user" name="username" placeholder="Insert username" required>
		
		<label for="pass" class="login-text">Password: </label>
			
		<input type="password" id="pass" name="password" placeholder="Insert password" required>
		
		<button type="submit" value="Login" name="pulsante">Login</button>
	</form>

	
</body>
</html>