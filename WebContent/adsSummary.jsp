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
	document.getElementById("summary").method = "GET";
	document.getElementById("summary").target = "_blank";
	document.getElementById("summary").submit();
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
							<form name="summary" id="summary">
								<table border=1 class="table table-responsive table-bordered">
									<c:set var = "adSummaryModel" value = "${summaryOfAd}"/>
									<c:set var = "userAdAssoc" value = "${userAdAssociation}"/>
									<c:set var = "userIsNotLeasingOffice" value = "${userIsNotLeasingOffice}"/>
									
									<tr>
										<c:choose>
											<c:when test="${adSummaryModel.postedUserType eq 'LeasingOffice'}">
												<td>
													Community HomePage:
													<a href="#" onclick="goToCommunityHomePage(${adSummaryModel.userId})">Click here to go to Community Homepage</a>
												</td>
					
											</c:when>
										<c:otherwise>
					
										</c:otherwise>
										</c:choose>	

										<td>
											<img src="${summaryOfAd.imageUrl}" alt="Smiley face" class="img-thumbnail" />
										</td>
										<td>
												<h2>${adSummaryModel.title}</h2>
												<h5>Description:</h5>
												<p>${adSummaryModel.description}</p>
												<h5>Community:</h5>
												<p>${adSummaryModel.community}</p>
												<h5>Preferences:</h5>
												<p>${adSummaryModel.preferences}</p>
										</td>
									</tr>
									<c:if test="${userIsNotLeasingOffice == true}">    
									<c:if test="${userAdAssoc == false}">
										<button type ='submit' class='btn' onclick="addInterest(${adSummaryModel.id})">I am Interested</button>
									
									</c:if>
									<c:if test="${userAdAssoc == true}">
										<button disabled="disabled" class='btn'>Interest Shown Already</button>
									</c:if>
									</c:if>
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
</html>