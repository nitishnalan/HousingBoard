<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<script type="text/javascript">
 function checkRequest(){
	//alert("checkRequest called : ");
	console.log("calling from checkRequest : ");
	document.getElementById("regform").action = "/HousingBoard/checkAdRequest/reviewInterests";
	document.getElementById("regform").method = "POST";
	document.getElementById("regform").submit();
}
 
 function updateProfile(){
		//alert("updateProfile called : ");
		console.log("calling from checkRequest : ");
		document.getElementById("regform").action = "/HousingBoard/updateprofile/dataretrieve";
		document.getElementById("regform").method = "POST";
		document.getElementById("regform").submit();
}
 
function redirectToDashBoard(){
		//alert("updateProfile called : ");
		console.log("calling from redirectToDashBoard : ");
		document.getElementById("regform").action = "/HousingBoard/redirect/dashBoard";
		document.getElementById("regform").method = "POST";
		document.getElementById("regform").submit();
}

function logOut(){
	//alert("updateProfile called : ");
	console.log("calling from logOut : ");
	document.getElementById("regform").action = "/HousingBoard/logOut";
	document.getElementById("regform").method = "POST";
	document.getElementById("regform").submit();
}
</script>
<title>Edit Personal Information</title>
</head>
<body>
<nav class="navbar navbar-expand navbar-light blue-sky">
		<a class="navbar-brand text-white" href="#"> HousingBoard </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
		 </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link text-white" href="#" onclick="redirectToDashBoard()"> Dashboard </a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link text-white" id="search-ads" href="/HousingBoard/searchAds.jsp">Search</a>
		      </li>
		      <li class="nav-item">
				<a class="nav-link text-white" id="request" onclick="checkRequest()">Requests</a>
		      </li>		
		      <li class="nav-item">
		  		<a class="nav-link text-white" href="/HousingBoard/AdForm.jsp">Manage Ads</a>
		      </li>						
		    </ul>
		  </div>
		  <button class="btn blue-sky" onclick="updateProfile()">Update Details</button>
		<a class="navbar-brand text-white" href="#" onclick="logOut()"> Logout </a>
	</nav>
	<div class="container-fluid granite">
    <div class="container">
      <div class="row">
      <div class="col-md-12">
      <form name="regform" action="/HousingBoard/updateUser" method="post" onsubmit="return regValidate()">
	<h2>Update Details</h2>
<c:set var = "users" value = "${users}"/>
<div class="form-group">
	<label>Email-Id</label>	
	<input class="form-control" type="email" name="email_id" value = "<c:out value="${users.emailId}" />" placeholder="Email-ID" required/>	
</div>
<div class="form-group">
		<label>Name</label>	
		<input class="form-control" type="text" name="full_name" value = "<c:out value="${users.name}" />"placeholder="Full Name" required>
</div>
<div class="form-group">
		<label>Phone</label>	<input class="form-control" type="text" name="phone_no" value = "<c:out value="${users.phoneNumb}" />" placeholder="Phone Number" required/>

	</div>
	<div class="form-group">
			<label>Address</label>	
			<input class="form-control" type="text" name="address" value = "<c:out value="${users.address}" />" placeholder="Address" required/>
		</div>
		<div class="form-group">
				<label>Zipcode</label>
				<input class="form-control" type="text" name="zipcode" value ="<c:out value="${users.zipcode}" />" placeholder="Zipcode" required/>
			</div>
			<div class="form-group">
					<label >City</label>	
					<input class="form-control" type="text" name="city" value = "<c:out value="${users.city}" />" placeholder="City" required/>
				</div>
				<div class="form-group">
						<label>State</label>	
						<input class="form-control" type="text" name="state" value ="<c:out value="${users.state}" />" placeholder="State" required/>	
					</div>
					<div class="form-group">
							<label>Country</label>	
							<input class="form-control" type="text" name="country" value = "<c:out value="${users.country}" />" placeholder="Country" required/>
						</div>
						<div class="form-group">
								<input type="submit" name="submit" value="Update" >
						</div>
</form>
      </div>
</div>
</div>
</div>

</body>
</html>