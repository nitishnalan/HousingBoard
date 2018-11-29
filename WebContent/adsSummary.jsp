<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADs Summary Page</title>
<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">

<script type="text/javascript">
function addInterest(adID){
	//alert("addInterest called : " + adID);
	console.log("calling from addInterest : " + adID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("summary").action = "/HousingBoard/showAdInterest/"+adID;
	document.getElementById("summary").method = "POST";
	document.getElementById("summary").submit();
}

function goToCommunityHomePage(userID){
	//alert("goToCommunityHomePage called : " + userID);
	console.log("calling from goToCommunityHomePage : " + userID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("summary").action = "/HousingBoard/communitySummary/"+userID;
	document.getElementById("summary").method = "POST";
	document.getElementById("summary").target = "_blank";
	document.getElementById("summary").submit();
}
</script>
<script type="text/javascript">
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
		        <a class="nav-link text-white" href="#" onclick="redirectToDashBoard()"> Dashboard </a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link text-white" id="search-ads" href="/HousingBoard/searchAds.jsp">Search</a>
		      </li>
		      <li class="nav-item">
				<a class="nav-link text-white" id="request" onclick="checkRequest()">Requests</a>
		      </li>		
		      <li class="nav-item">
		  		<a class="nav-link text-white" href="AdForm.jsp">Manage Ads</a>
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
							<form name="summary" id="summary">
								<!-- <table class="table table-responsive table-bordered"> -->
									<c:set var = "adSummaryModel" value = "${summaryOfAd}"/>
									<c:set var = "userAdAssoc" value = "${userAdAssociation}"/>
									<c:set var = "userIsNotLeasingOffice" value = "${userIsNotLeasingOffice}"/>
									<!-- <tr> -->
										<c:choose>
											<c:when test="${adSummaryModel.postedUserType eq 'LeasingOffice'}">
												<!-- <td> -->
													<div class="row">
                                                        <div class="col-md-12">
                                                            <h2>Community HomePage:<h2>
                                                            <a href="#" onclick="goToCommunityHomePage(${adSummaryModel.userId})">Click here to go to Community Homepage</a>
                                                        </div>
                                                    </div>
												<!-- </td> -->
											</c:when>
										<c:otherwise>
					
										</c:otherwise>
										</c:choose>	

										<!-- <td> -->
											
										<!-- </td> -->
										<!-- <td> -->
                                            <div class="card text-dark">
                                                <h2 class="card-header text-dark">
                                                    ${adSummaryModel.title}
                                                </h2>
                                                <div class="card-body">
													<div class="row">
														<div class="col-md-5">
															<img src="${summaryOfAd.imageUrl}" alt="Smiley face" class="img-thumbnail" />				
														</div>
														<div class="col-md-7">
																<h5>Description:</h5>
																<p>${adSummaryModel.description}</p>
																<h5>Community:</h5>
																<p>${adSummaryModel.community}</p>
																<h5>Preferences:</h5>
																<p>${adSummaryModel.preferences}</p>
																<c:if test="${userIsNotLeasingOffice == true}">    
																<c:if test="${userAdAssoc == false}">
																	<button type ='submit' class='btn blue-sky' onclick="addInterest(${adSummaryModel.id})">I am Interested</button>
																
																</c:if>
																<c:if test="${userAdAssoc == true}">
																	<button disabled="disabled" class='btn'>Interest Shown Already</button>
																</c:if>
																</c:if>
														</div>
													</div>
                                                        
                                                </div>
                                            </div>
												
										<!-- </td> -->
									<!-- </tr> -->
									
								<!-- </table> -->
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