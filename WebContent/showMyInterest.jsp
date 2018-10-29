<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show My Interest Page</title>
<script type="text/javascript">
function getDetails(usrID){
	alert("declineInterest called@ : " + usrID);
	console.log("calling from declineInterest : " + usrID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("reviewInterests").action = "/HousingBoard/checkAdRequest/decline/"+usrID+"/"+inteID;
	document.getElementById("reviewInterests").method = "POST";
	document.getElementById("reviewInterests").submit();
}
</script>
</head>
<body>
<form>
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
						<td><button type ='button' class='btn' onclick="getDetails(${userAdInt.postedUserId});">Get Contact Details</button></td>
						
					</c:when>
					<c:otherwise>
					
					</c:otherwise>
				</c:choose>	
				<td hidden id="tdHide"></td>
			</tr>
		</c:forEach>
	</table>			
</form>
</body>
</html>