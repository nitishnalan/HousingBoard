<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request On ADs</title>
<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">

<script type="text/javascript">
function declineInterest(usrID,inteID){
	//alert("declineInterest called@ : " + usrID);
	console.log("calling from declineInterest : " + usrID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("reviewInterests").action = "/HousingBoard/checkAdRequest/decline/"+usrID+"/"+inteID;
	document.getElementById("reviewInterests").method = "POST";
	document.getElementById("reviewInterests").submit();
}

function approveInterest(usrID,inteID){
	//alert("approveInterest called : " + usrID);
	console.log("calling from approveInterest : " + usrID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("reviewInterests").action = "/HousingBoard/checkAdRequest/approve/"+usrID+"/"+inteID;
	document.getElementById("reviewInterests").method = "POST";
	document.getElementById("reviewInterests").submit();
}
function showDetailsOfADs(adId){
	//alert("declineInterest called@ : " + usrID);
	console.log("calling from declineInterest : " + adId);

	document.getElementById("reviewInterests").action = "/HousingBoard/adDetails/"+adId;
	document.getElementById("reviewInterests").method = "POST";
	document.getElementById("reviewInterests").target = "_blank";
	document.getElementById("reviewInterests").submit();
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
        <form id="reviewInterests">
        	Requests received on the ADs posted by you:
        	<table border=1 class="table table-responsive table-bordered">
        	
        		<c:forEach items="${checkAdUserInterests}" var="checkUsrAdInt">
        			<tr>
        				<td>${checkUsrAdInt.userName}</td>
        				<td>${checkUsrAdInt.userEmailId}</td>
        				<td>${checkUsrAdInt.userPhoneNo}</td>
        				<td>${checkUsrAdInt.statusValue}</td>
        				<td>
        				<c:choose>
        					<c:when test="${checkUsrAdInt.statusValue eq 'Approved'}">
        						<button type ='button' class='btn blue-sky' onclick="declineInterest(${checkUsrAdInt.interestShowerUserId},${checkUsrAdInt.interestID})">Decline</button>
        						<button type ='button' class='btn blue-sky' onclick="showDetailsOfADs(${checkUsrAdInt.ad_id})">Show details of ADs</button>
        					</c:when>
        					<c:otherwise>
        						<button type ='button' class='btn blue-sky' onclick="approveInterest(${checkUsrAdInt.interestShowerUserId},${checkUsrAdInt.interestID});">Approve</button>
        						<button type ='button' class='btn blue-sky' onclick="declineInterest(${checkUsrAdInt.interestShowerUserId},${checkUsrAdInt.interestID})">Decline</button>
        						<button type ='button' class='btn blue-sky' onclick="showDetailsOfADs(${checkUsrAdInt.ad_id})">Show details of ADs</button>
        					</c:otherwise>
        				</c:choose>
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
</html>