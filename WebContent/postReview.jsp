<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Review</title>
<script type="text/javascript">
function postReviewForCommunity(communityPgID){
	alert("postReviewForCommunity called : " + communityPgID);
	console.log("postReviewForCommunity from communityPgID : " + communityPgID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("postReview").action = "/HousingBoard/review/postReview/"+communityPgID;
	document.getElementById("postReview").method = "POST";
	document.getElementById("postReview").submit();
}

</script>
</head>
<body>
<form name="postReview" id="postReview">
		This is Community Summary Page:
	
	<table border=1>
		<c:set var = "communityPg" value = "${communityObjForAddReview}"/>

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
	
	<table border=1>
		<tr>
			<td>
				<B>Post A Reviews:</B>
				
			</td>
		</tr>
		<tr>
			<td>
				<textarea rows="4" cols="50" id="review" name="review">
	
				</textarea>
			</td>		
		</tr>
		<tr>
			<td>
				<button type ='submit' class='btn' onclick="postReviewForCommunity(${communityPg.id})">
					Post The Review
				</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>