<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Community Summary Page</title>
<script type="text/javascript">
function addReviewForCommunity(communityPgID){
	alert("addReviewForCommunity called : " + communityPgID);
	console.log("addReviewForCommunity from communityPgID : " + communityPgID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("communitySummary").action = "/HousingBoard/review/addReview/"+communityPgID;
	document.getElementById("communitySummary").method = "POST";
	document.getElementById("communitySummary").submit();
}

</script>
</head>
<body>
<form name="communitySummary" id="communitySummary">
	This is Community Summary Page:
	
	<table border=1>
		<c:set var = "communityPg" value = "${communityObj}"/>
		<c:set var = "userCommunityPgAssoc" value = "${userCommunityPgAssoc}"/>
		<tr>
			<td>
				<img src="${communityPg.imageUrl}" alt="Smiley face" width="500" height="500" />
			</td>
		</tr>
		<tr>
			<td>
				Name:
					${communityPg.name}
			</td>		
		</tr>
			
		<tr>
			<td>
				About our community:
				${communityPg.pageDescription}
			</td>			
		</tr>
		
	</table>
	
	<c:set var = "reviews" value = "${communityObj.getReviewsCommunity()}"/>
	
	<table border=1>
		<tr>
			<td>
				<B>Reviews:</B>
				<%-- <table border=1>
					<c:forEach items="${searchResultsOfAds}" var="adPost">
					
					</c:forEach>
				</table> --%>
			</td>
		</tr>
		<c:if test="${userCommunityPgAssoc != true}">
		<tr>
			<td>
				<button type ='submit' class='btn' onclick="addReviewForCommunity(${communityPg.id})">
					Add a Review for this community
				</button>
			</td>
		</tr>
		</c:if>
		<c:if test="${reviews != null}">
		<tr>
			<td>
				<c:forEach items="${communityPg.getReviewsCommunity()}" var="communityPgReviews">
				<tr>
					<td>
						${communityPgReviews.userName} : ${communityPgReviews.description}
					</td>					
				</tr>
					
				</c:forEach>
			</td>
		</tr>
		</c:if>
		<c:if test="${reviews == null}">
		<tr>
			<td>
				There is no review available for this community. You can be the first one to review..
			</td>
		</tr>
		</c:if>
	</table>
	
</form>
</body>
</html>