<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ads Application</title>
    <!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
 function checkRequest(){
	//alert("checkRequest called : ");
	console.log("calling from checkRequest : ");
	document.getElementById("search").action = "/HousingBoard/checkAdRequest/reviewInterests";
	document.getElementById("search").method = "POST";
	document.getElementById("search").submit();
}
 
 function updateProfile(){
		//alert("updateProfile called : ");
		console.log("calling from checkRequest : ");
		document.getElementById("search").action = "/HousingBoard/updateprofile/dataretrieve";
		document.getElementById("search").method = "POST";
		document.getElementById("search").submit();
}
 
function redirectToDashBoard(){
		//alert("updateProfile called : ");
		console.log("calling from redirectToDashBoard : ");
		document.getElementById("search").action = "/HousingBoard/redirect/dashBoard";
		document.getElementById("search").method = "POST";
		document.getElementById("search").submit();
}

function logOut(){
	//alert("updateProfile called : ");
	console.log("calling from logOut : ");
	document.getElementById("search").action = "/HousingBoard/logOut";
	document.getElementById("search").method = "POST";
	document.getElementById("search").submit();
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
			<form name="search" id="search" action = "/HousingBoard/ads/*" method="get">
		         <h2>List of Ads</h2>
		        <table class="table table-responsive">
		            <tr>
		                <th>Title</th>
		                <th>Image</th>
		                <th>Description</th>
		                <th>Community</th>
		                <th>Actions</th>
		            </tr>
		            <c:forEach var="ads" items="${listAds}">
		                <tr>
		                    <td><c:out value="${ads.title}" /></td>
		                    <td><img src="<c:out value="${ads.imageUrl}" />" alt="Showing Apartment" height="150" width="150"></td>                    
		                    <td><c:out value="${ads.description}" /></td>
		                    <td><c:out value="${ads.community}" /></td>
		                    <td>
		         			<a class="btn blue-sky" href='#' onclick="deleteAds(${ads.id});">Delete Ad</a>
							<a class="btn blue-sky" href='#' onclick="updateAds(${ads.id});">Update Ad</a>
		 					</td>
		                </tr>
		            </c:forEach>
		        </table>
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
<script type="text/javascript">
function deleteAds(adID){
	console.log("calling from Delete Ad : " + adID);
	document.getElementById("search").action = "/HousingBoard/ads/delete?id="+adID;
	document.getElementById("search").method = "POST";
	document.getElementById("search").submit();
}

function updateAds(adID){
	console.log("calling from Update Ad : " + adID);
	document.getElementById("search").action = "/HousingBoard/ads/edit?id="+adID;
	document.getElementById("search").method = "POST";
	document.getElementById("search").submit();
}
</script>
</html>