<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HousingBoard</title>

</head>
<body>
<form name="regform" action="/HousingBoard/updateUser" method="post" onsubmit="return regValidate()">
	<h2>Update Details</h2>
	<p>Following is the user type:</p><br/>
	<input type="radio" name="user_type" value="member" />Member<br/>
		
	<input type="email" name="email_id" placeholder="Email-ID" required/><br>
	
	<input type="text" name="full_name" placeholder="Full Name" required><br>
	
	<input type="password" name="password" id="password" placeholder="Password" required><br>
	
	<input type="password" name="confirm_password" id="retry-password" placeholder="Confirm Password" required/><br>
	
	<input type="text" name="phone_no" placeholder="Phone Number" required/><br>
	
	<input type="text" name="address" placeholder="Address" required/><br>
	
	<input type="text" name="zipcode" placeholder="Zipcode" required/><br>
	
	<input type="text" name="city" placeholder="City" required/><br>

	<input type="text" name="state" placeholder="State" required/><br>	
	
	<input type="text" name="country" placeholder="Country" required/><br>
	
	<input type="submit" name="submit" value="Update" >
	<input type="reset" name="Reset">
	
	</form>
	
</body>
</html>