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
<link rel="stylesheet" href="css/style.css"></link>
<title>HousingBoard Registration</title>

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
	<table border=1>
		<c:forEach items="${userInterests}" var="userAdInt">
			<tr>
				<td><img src="${userAdInt.imageUrl}" alt="Smiley face" width="60" height="60" /></td>
				<td>${userAdInt.title}</td>
				<td>${userAdInt.description}</td>
				<td>${userAdInt.community}</td>
				<td>${userAdInt.statusOfInterest}</td>
				
				<c:choose>
					<c:when test="${userAdInt.statusOfInterest eq 'Approved'}">
						<td><button type ='button' onclick="getDetails(${userAdInt.postedUserId});">Get Contact Details</button></td>
						
					</c:when>
					<c:otherwise>
					
					</c:otherwise>
				</c:choose>	
				<td hidden id="tdHide"></td>
			</tr>
		</c:forEach>
</body>
</html>