<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member - Home Page</title>
<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">

<script type="text/javascript">
function showMyInterests(){
	alert("showMyInterests called : ");
	console.log("calling from showMyInterests : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/showAdInterest/myInterests";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}

function checkRequest(){
	alert("checkRequest called : ");
	console.log("calling from checkRequest : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/checkAdRequest/reviewInterests";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}
</script>
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
	          <form id="memberDashboard" name="memberDashboard">
	            <h2>Hello Member User - ${user.name}</h2>
	            <p>If you would like to created an Ad please click this button: </p>
	            <div class="row">
	              <div class="col-md-3"><a class="btn blue-sky" href="/HousingBoard/createAds.jsp">Create Ad</a></div>
	              
	              <div class="col-md-3"><a class="btn blue-sky" href="/HousingBoard/searchAds.jsp">Search</a></div>
	              
	              <div class="col-md-3"><button class="btn blue-sky" onclick="showMyInterests()">Interests</button></div>
	              
	              <div class="col-md-3"><button class="btn blue-sky" onclick="checkRequest()">Requests</button></div>
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