<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HousingBoard Login</title>
<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="css/style.css"></link>
<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">

</head>
<body>
    <nav class="navbar navbar-light blue-sky">
        <a class="navbar-brand text-white" href="#">
            HousingBoard
        </a>
    </nav>
	<div class="container-fluid granite">
	  <div class="container">
	    <div class="row">
	      <div class="col-md-12">
	        <form name="loginform" action="/HousingBoard/login" method="post">
        	<%-- ${message} &nbsp; ${successMessage} --%>
        	<h2 class="text-center">Login</h2>
        	<div class="form-group">
        	  <div class="form-check form-check-inline">
              <input type="radio" name="user_type" value="member" />
              <label class="form-check-label">Member</label>
            </div>
          	<div class="form-check form-check-inline">
              <input type="radio" name="user_type" value="leasing_office" />
              <label class="form-check-label">Leasing Office</label>
            </div>
        	</div>
        	<div class="form-group">
            <input class="form-control" type="text" name="email_id" id="email_id" placeholder="Email-ID" required/>
          </div>
        	
        	<div class="form-group">
            <input class="form-control" type="password" name="password" id="password" placeholder="Password" required/>
          </div>
        	<input class="btn blue-sky btn-block" type="submit" name="submit" value="Login"/>
        	<p class="text-center">Not a User ?<br><a class="btn blue-sky" id="register" href="register.jsp"> Register Here !</a></p>
        	
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