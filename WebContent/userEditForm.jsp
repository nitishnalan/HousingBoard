<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
label {
  width:100px;
  display: inline-block;
}
</style>
<title>Edit Personal Information</title>
</head>
<body>
<form name="regform" action="/HousingBoard/updateUser" method="post" onsubmit="return regValidate()">
	<h2>Update Details</h2>
	
<label>EmailId</label>	<input type="email" name="email_id" value = "<c:out value="${user.emailId}" />" placeholder="Email-ID" required/><br>
	
<label>Name</label>	<input type="text" name="full_name" value = "<c:out value="${user.name}" />"placeholder="Full Name" required><br>

<label>Phone</label>	<input type="text" name="phone_no" value = "<c:out value="${user.phoneNumb}" />" placeholder="Phone Number" required/><br>
	
<label>Address</label>	<input type="text" name="address" value = "<c:out value="${user.address}" />" placeholder="Address" required/><br>
	
<label>Zipcode</label>	<input type="text" name="zipcode" value ="<c:out value="${user.zipcode}" />" placeholder="Zipcode" required/><br>
	
<label >City</label>	<input type="text" name="city" value = "<c:out value="${user.city}" />" placeholder="City" required/><br>

<label>State</label>	<input type="text" name="state" value ="<c:out value="${user.state}" />" placeholder="State" required/><br>	
	
<label>Country</label>	<input type="text" name="country" value = "<c:out value="${user.country}" />" placeholder="Country" required/><br>
	
	<input type="submit" name="submit" value="Update" >
	
	</form>
</body>
</html>