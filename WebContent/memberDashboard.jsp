<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member - Home Page</title>
<!-- Bootstrap CSS  -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<link href="https://fonts.googleapis.com/css?family=Titillium+Web"
	rel="stylesheet" />
<script type="text/javascript">
function showMyInterests(){
	//alert("showMyInterests called : ");
	console.log("calling from showMyInterests : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/showAdInterest/myInterests";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}

 function checkRequest(){
	//alert("checkRequest called : ");
	console.log("calling from checkRequest : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/checkAdRequest/reviewInterests";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}
 
 function updateProfile(){
		//alert("updateProfile called : ");
		console.log("calling from checkRequest : ");
		document.getElementById("memberDashboard").action = "/HousingBoard/updateprofile/dataretrieve";
		document.getElementById("memberDashboard").method = "POST";
		document.getElementById("memberDashboard").submit();
}
 
function redirectToDashBoard(){
		//alert("updateProfile called : ");
		console.log("calling from redirectToDashBoard : ");
		document.getElementById("memberDashboard").action = "/HousingBoard/redirect/dashBoard";
		document.getElementById("memberDashboard").method = "POST";
		document.getElementById("memberDashboard").submit();
}

function logOut(){
	//alert("updateProfile called : ");
	console.log("calling from logOut : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/logOut";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}
</script>
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
		        <a class="nav-link text-white" href="#" onclick="redirectToDashBoard()">Dashboard</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link text-white" id="search-ads" href="/HousingBoard/searchAds.jsp">Search</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link text-white" id="show-interest" onclick="showMyInterests()">Interests</a>
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
					<form id="memberDashboard" name="memberDashboard">
						<h2>Hello Member User - ${user.name}</h2>
						<div class="row">
							<div class="col-md-6">
								If you would like to created an Ad please click this button:&nbsp;<a class="btn blue-sky" id="create-ad" href="/HousingBoard/AdForm.jsp">Create Ad</a>
							</div>
							<!--<div class="col-md-3">
								<button class="btn blue-sky" id="show-interest" onclick="showMyInterests()">Interests</button>
							</div>-->
							<!-- <div class="col-md-3">
								<button class="btn blue-sky" id="request" onclick="checkRequest()">Requests</button>
							</div> -->
							<!--<div class="col-md-6">
								<button class="btn blue-sky" onclick="updateProfile()">Update Details</button>
							</div> -->
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap JS  -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	
	<br />
	<br />
	<br />
	</form>
</body>
</html>
