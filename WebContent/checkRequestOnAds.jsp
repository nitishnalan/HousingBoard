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
<link rel="stylesheet" href="css/style.css"></link>
<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">

<script type="text/javascript">
function declineInterest(usrID,inteID){
	alert("declineInterest called@ : " + usrID);
	console.log("calling from declineInterest : " + usrID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("reviewInterests").action = "/HousingBoard/checkAdRequest/decline/"+usrID+"/"+inteID;
	document.getElementById("reviewInterests").method = "POST";
	document.getElementById("reviewInterests").submit();
}

function approveInterest(usrID,inteID){
	alert("approveInterest called : " + usrID);
	console.log("calling from approveInterest : " + usrID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("reviewInterests").action = "/HousingBoard/checkAdRequest/approve/"+usrID+"/"+inteID;
	document.getElementById("reviewInterests").method = "POST";
	document.getElementById("reviewInterests").submit();
}
</script>
</head>
<body>
<form id="reviewInterests">
	<table border=1>
		<c:forEach items="${checkAdUserInterests}" var="checkUsrAdInt">
			<tr>
				<td>${checkUsrAdInt.userName}</td>
				<td>${checkUsrAdInt.userEmailId}</td>
				<td>${checkUsrAdInt.userPhoneNo}</td>
				<td>${checkUsrAdInt.statusValue}</td>
				<td>
				<c:choose>
					<c:when test="${checkUsrAdInt.statusValue eq 'Approved'}">
						<button type ='button' class='btn' onclick="declineInterest(${checkUsrAdInt.interestShowerUserId},${checkUsrAdInt.interestID})">Decline</button>
						
					</c:when>
					<c:otherwise>
						<button type ='button' class='btn' onclick="approveInterest(${checkUsrAdInt.interestShowerUserId},${checkUsrAdInt.interestID});">Approve</button>
						<button type ='button' class='btn' onclick="declineInterest(${checkUsrAdInt.interestShowerUserId},${checkUsrAdInt.interestID})">Decline</button>
					</c:otherwise>
				</c:choose>
				</td>	
			</tr>
		</c:forEach>
	</table>			
</form>
</body>
</html>