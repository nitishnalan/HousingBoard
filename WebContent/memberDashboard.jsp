<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member - Home Page</title>
<script type="text/javascript">
function showMyInterests(){
	alert("showMyInterests called : ");
	console.log("calling from showMyInterests : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/showAdInterest/myInterests";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}

function checkRequest(){
	alert("checkRequest called : ");
	console.log("calling from checkRequest : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/checkAdRequest/reviewInterests";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}
</script>
</head>
<body>

<table>
<tr>
<td>
<h4><a href="editform.jsp"><button>Update Details</button></a></h4><br/><br/>
</td>
<td>
<h4><a href ="AdForm.jsp"><button>Manage Ads</button></a></h4><br/><br/>
</td>
</tr>
</table>

<form id="memberDashboard" name="memberDashboard">

	Hello Member User - ${user.name},

	
	<a href="/HousingBoard/searchAds.jsp">Search ADs</a>
	
	<br/>
	
	<a href="#" onclick="showMyInterests()">Show My Interest Page</a>
	
	<br/>
	
	<a href="#" onclick="checkRequest()">Check Interest on my AD Request </a>
</form>	
</body>
</html>