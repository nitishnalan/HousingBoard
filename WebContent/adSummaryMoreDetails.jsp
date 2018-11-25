<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADs User Details</title>
<script type="text/javascript">
function addInterest(adID){
	alert("addInterest called : " + adID);
	console.log("calling from addInterest : " + adID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("summary").action = "/HousingBoard/showAdInterest/"+adID;
	document.getElementById("summary").method = "POST";
	document.getElementById("summary").submit();
}
</script>
</head>
<body>
<form name="summary" id="summary">

This is a ADs Summary Page:

	<table border=1>
		<c:set var = "adSummaryModel" value = "${summaryOfAdAndUser}"/>
		<tr>
			<td>
				<img src="${adSummaryModel.imageUrl}" alt="Smiley face" width="500" height="500" />
			</td>
		</tr>
		<tr>
			
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
			<td>
				User Email ID:
				${adSummaryModel.emailId}
			</td>
			<td>
				User Contact No.:
				${adSummaryModel.phoneNumb}
			</td>
		</tr>
		
	</table>
</form>	
</body>
</html>