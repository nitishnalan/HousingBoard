<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post ADs</title>
</head>
<body>
<form name="regform" action="/HousingBoard/ads" method="post" >
	<input type="text" name="title" placeholder="Title" required/><br>
	
	<input type="text" name="imageUrl" placeholder="Image Url" required><br>
	
	<input type="text" name="description" placeholder="Description" required><br>
	
	<input type="text" name="community" placeholder="Community Name" required/><br>
	
	<input type="submit" name="submit" value="Post An Add" >

</form>
</body>
</html>