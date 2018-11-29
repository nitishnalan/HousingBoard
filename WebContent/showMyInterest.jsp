<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
 function checkRequest(){
	//alert("checkRequest called : ");
	console.log("calling from checkRequest : ");
	document.getElementById("moreDetails").action = "/HousingBoard/checkAdRequest/reviewInterests";
	document.getElementById("moreDetails").method = "POST";
	document.getElementById("moreDetails").submit();
}
 
 function updateProfile(){
		//alert("updateProfile called : ");
		console.log("calling from checkRequest : ");
		document.getElementById("moreDetails").action = "/HousingBoard/updateprofile/dataretrieve";
		document.getElementById("moreDetails").method = "POST";
		document.getElementById("moreDetails").submit();
}
 
function redirectToDashBoard(){
		//alert("updateProfile called : ");
		console.log("calling from redirectToDashBoard : ");
		document.getElementById("moreDetails").action = "/HousingBoard/redirect/dashBoard";
		document.getElementById("moreDetails").method = "POST";
		document.getElementById("moreDetails").submit();
}

function logOut(){
	//alert("updateProfile called : ");
	console.log("calling from logOut : ");
	document.getElementById("moreDetails").action = "/HousingBoard/logOut";
	document.getElementById("moreDetails").method = "POST";
	document.getElementById("moreDetails").submit();
}
</script>

<script type="text/javascript">
function getDetails(adID){
	alert("getDetails called@ : " + adID);
	console.log("calling from getDetails : " + adID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("moreDetails").action = "/HousingBoard/adDetails/"+adID;
	document.getElementById("moreDetails").method = "GET";
	document.getElementById("moreDetails").submit();
}
</script>
<title>Show My Interest Page</title>


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
            <form id="moreDetails">
                <table class="table table-responsive table-bordered">
                  <c:forEach items="${userInterests}" var="userAdInt">
                    <tr>
                      <td><img src="${userAdInt.imageUrl}" alt="Smiley face" width="60" height="60" /></td>
                      <td>${userAdInt.title}</td>
                      <td>${userAdInt.description}</td>
                      <td>${userAdInt.community}</td>
                      <td>${userAdInt.statusOfInterest}</td>
                      
                      <c:choose>
                        <c:when test="${userAdInt.statusOfInterest eq 'Approved'}">
                          <td><button type ='button' class="btn blue-sky" onclick="getDetails(${userAdInt.postedUserId});">Get Contact Details</button></td>
                          
                        </c:when>
                        <c:otherwise>
                        
                        </c:otherwise>
                      </c:choose>	
                      <td hidden id="tdHide"></td>
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
</html>