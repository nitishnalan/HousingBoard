<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leasing Office Page Creation</title>
</head>
<body>
<h1>
Page Creation</h1>


<form name="regform" action="/HousingBoard/updateprofile/createpage" method="post" onsubmit="return regValidate()">
	<h2>Insert Details</h2>
	
<label>Community Desciption</label>	<input type="text" name="pagedescription"  placeholder="Description" required/><br>
	
<label>Community URL</label>	<input type="text" name="url" placeholder="Community URL" required><br>

	<input type="submit" name="submit" value="save" >
	
	</form>


</body>
</html>