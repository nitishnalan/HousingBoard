<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<title>HousingBoard Registration</title>
</head>
<body>
	<input type="text" name="state" placeholder="State" required/><br>	
	
	<input type="text" name="country" placeholder="Country" required/><br>
	
	<input type="submit" name="submit" value="Register" >
	<input type="reset" name="Reset">
	
</form>
	<nav class="navbar navbar-light blue-sky">
	  <a class="navbar-brand text-white" href="#">
	    HousingBoard
	  </a>
	</nav>
	<div class="container-fluid granite" style="color:white">
	    <div class="container">
	      <div class="row">
	        <div class="col-md-12">
	          <form name="regform" action="/HousingBoard/registerUser" method="post" onsubmit="return regValidate()">
	            ${message}
	            <h2 class="text-center">Registration</h2>
	            <div class="form-group">
	              <label>Select user type:</label>
	              <div class="form-check form-check-inline">
	                <input type="radio" name="user_type" value="member" />
	                <label class="form-check-label">
	                  &nbsp;Member
	                </label>
	              </div>
	              <div class="form-check form-check-inline">
	                <input type="radio" name="user_type" value="leasing_office" />
	                <label class="form-check-label">
	                  &nbsp;Leasing Office
	                </label>
	              </div>
	            </div>
	            <div class="form-group">
	              <div class="form-row">
	                <div class="col"><input type="email" class="form-control" name="email_id" placeholder="Email-ID*" required/></div>
	                <div class="col"><input type="text" class="form-control" name="full_name" placeholder="Full Name*" required></div>
	                <div class="col"><input type="text" class="form-control" name="phone_no" placeholder="Phone Number*" required/></div>
	              </div>
	            </div>
	            <div class="form-group">
	              <div class="form-row">
	                <div class="col"><input type="password" class="form-control" name="password" id="password" placeholder="Password*" required /></div>
	                <div class="col"><input type="password" class="form-control" name="confirm_password" id="retry-password" placeholder="Confirm Password*" required /></div>
	              </div>
	            </div>
	            <div class="form-group">
	              <div class="form-row">
	                <div class="col"><input type="text" class="form-control" name="address" placeholder="Address*" required/></div>
	                <div class="col"><input type="text" class="form-control" name="zipcode" placeholder="Zipcode*" required/></div>
	              </div>
	            </div>
	            <div class="form-group">
	              <div class="form-row">
	                <div class="col"><input type="text" class="form-control" name="city" placeholder="City*" required/></div>
	                <div class="col"><input type="text" class="form-control" name="state" placeholder="State*" required/></div>
	                <div class="col"><input type="text" class="form-control" name="country" placeholder="Country*" required/></div>
	              </div>
	            </div>
	            <div class="form-group">
	              <input type="submit" class="btn blue-sky" name="submit" value="Register" >
	              <input type="reset" name="Reset" class="btn blue-sky">
	            </div>
	          </form>
	        </div>
	      </div>
	    </div>
  	</div>
	<!-- Bootstrap JS  -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>