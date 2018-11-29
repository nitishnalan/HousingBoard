<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Community Page</title>
<script type="text/javascript">
function saveCommunityChanges(communityID){
	//alert("addInterest called : " + adID);
	console.log("calling from saveCommunityChanges : " + communityID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("editCommunitySummary").action = "/HousingBoard/editCommunityPage/updateData/"+communityID;
	document.getElementById("editCommunitySummary").method = "POST";
	document.getElementById("editCommunitySummary").submit();
}

function goBack(communityID){
	//alert("addInterest called : " + adID);
	console.log("calling from goBack : " + communityID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("editCommunitySummary").action = "/HousingBoard/communitySummary/"+communityID;
	document.getElementById("editCommunitySummary").method = "POST";
	document.getElementById("editCommunitySummary").submit();
}
</script>
</head>
<body>
<form name="editCommunitySummary" id="editCommunitySummary">
	<table border=1>
		<c:set var = "communityPg" value = "${communityObj}"/>
		<tr>
			<td>
				<img src="${communityPg.imageUrl}" alt="Smiley face" width="500" height="500" />
			</td>
		</tr>
		<tr>
			<td>
				New Image Url:
			<input type="text" name="imageUrl" placeholder="New Image url address" size="85">
			</td>
			
		</tr>
		<tr>
			<td>
				Name:
				<input type="text" name="name" value = "<c:out value="${communityPg.name}" />" placeholder="Name" size="100">
					
			</td>		
		</tr>
		<tr>
			<td>
				About our community:
				<textarea name="description" rows="4" cols="50" value="" placeholder="About the community">${communityPg.pageDescription} </textarea>
						
			</td>		
		</tr>
	</table>
	<button type ='submit' class='btn' onclick="goBack(${communityPg.id})">Go Back</button> <br/>
	<button type ='submit' class='btn' onclick="saveCommunityChanges(${communityPg.id})">Save the changes</button>
</form>
</body>
</html>