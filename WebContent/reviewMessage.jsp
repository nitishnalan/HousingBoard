<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Message</title>
<script type="text/javascript">
function goBackAfterReview(communityPgID){
	alert("postReviewForCommunity called : " + communityPgID);
	console.log("postReviewForCommunity from communityPgID : " + communityPgID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("reviewSuccess").action = "/HousingBoard/communitySummary/"+communityPgID;
	document.getElementById("reviewSuccess").method = "POST";
	document.getElementById("reviewSuccess").submit();
}

</script>
</head>
<body>
<form name="reviewSuccess" id="reviewSuccess">
${reviewMessage}

<button type ='submit' class='btn' onclick="goBackAfterReview(${reviewForCommunityPgId})">
	Go Back
</button>
</form>
</body>
</html>