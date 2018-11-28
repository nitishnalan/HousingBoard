<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HousingBoard</title>
</head>
<body>
	<form name="loginform" action="/HousingBoard/adminlogin" method="post">
	<%-- ${message} &nbsp; ${successMessage} --%>
	<h2>Admin Login</h2>
	<input type="text" name="email_id" id="email_id" placeholder="Email-ID" required/><br>
	
	<input type="password" name="password" id="password" placeholder="Password" required/><br>
	
	<input type="submit" name="submit" value="Login"><br>
	</form>
</body>
</html>