<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADs Summary Page</title>
<script type="text/javascript">
function addInterest(adID){
	alert("addInterest called : " + adID);
	console.log("calling from addInterest : " + adID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("summary").action = "/HousingBoard/showAdInterest/"+adID;
	document.getElementById("summary").method = "POST";
	document.getElementById("summary").submit();
}

function goToCommunityHomePage(userID){
	alert("goToCommunityHomePage called : " + userID);
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
<form name="summary" id="summary">

This is a ADs Summary Page:

	<table border=1>
		<c:set var = "adSummaryModel" value = "${summaryOfAd}"/>
		<c:set var = "userAdAssoc" value = "${userAdAssociation}"/>
		<tr>
			<td>
				<img src="${adSummaryModel.imageUrl}" alt="Smiley face" width="500" height="500" />
			</td>
		</tr>
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
				Title:
				${adSummaryModel.title}
			</td>
			
			<td>
				Description:
				${adSummaryModel.description}
			</td>
			
			<td>
				Community:
				${adSummaryModel.community}
			</td>
			
			<td>
				Preferences:
				${adSummaryModel.preferences}
			</td>
		</tr>
<%-- 		<c:choose>
			<c:when test="${userAdAssoc}">
				<button type ='submit' class='btn' onclick="addInterest(${adSummaryModel.id})">I am Interested</button>
			</c:when>
			<c:otherwise>
				<button disabled="disabled" class='btn'>Interest Shown Already</button>
			</c:otherwise>
		</c:choose>	 --%>
		<c:if test="${userAdAssoc == false}">
			<button type ='submit' class='btn' onclick="addInterest(${adSummaryModel.id})">I am Interested</button>
		</c:if>
		<c:if test="${userAdAssoc == true}">
			<button disabled="disabled" class='btn'>Interest Shown Already</button>
		</c:if>
	</table>
</form>	
</body>
</html>