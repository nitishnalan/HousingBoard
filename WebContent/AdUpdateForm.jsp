<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ads Application</title>
    <!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
 function checkRequest(){
	//alert("checkRequest called : ");
	console.log("calling from checkRequest : ");
	document.getElementById("updateAd").action = "/HousingBoard/checkAdRequest/reviewInterests";
	document.getElementById("updateAd").method = "POST";
	document.getElementById("updateAd").submit();
}
 
 function updateProfile(){
		//alert("updateProfile called : ");
		console.log("calling from checkRequest : ");
		document.getElementById("updateAd").action = "/HousingBoard/updateprofile/dataretrieve";
		document.getElementById("updateAd").method = "POST";
		document.getElementById("updateAd").submit();
}
 
function redirectToDashBoard(){
		//alert("updateProfile called : ");
		console.log("calling from redirectToDashBoard : ");
		document.getElementById("updateAd").action = "/HousingBoard/redirect/dashBoard";
		document.getElementById("updateAd").method = "POST";
		document.getElementById("updateAd").submit();
}

function logOut(){
	//alert("updateProfile called : ");
	console.log("calling from logOut : ");
	document.getElementById("updateAd").action = "/HousingBoard/logOut";
	document.getElementById("updateAd").method = "POST";
	document.getElementById("updateAd").submit();
}
</script>
</head>
<body>
<nav class="navbar navbar-expand navbar-light blue-sky">
		<a class="navbar-brand text-white" href="#"> HousingBoard </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
		 </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link text-white" href="#" onclick="redirectToDashBoard()"> Dashboard </a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link text-white" id="search-ads" href="/HousingBoard/searchAds.jsp">Search</a>
		      </li>
		      <li class="nav-item">
				<a class="nav-link text-white" id="request" onclick="checkRequest()">Requests</a>
		      </li>		
		      <li class="nav-item">
		  		<a class="nav-link text-white" href="/HousingBoard/AdForm.jsp">Manage Ads</a>
		      </li>						
		    </ul>
		  </div>
		  <button class="btn blue-sky" onclick="updateProfile()">Update Details</button>
		<a class="navbar-brand text-white" href="#" onclick="logOut()"> Logout </a>
	</nav>
	<div class="container-fluid granite">
    <div class="container">
      <div class="row">
	      <div class="col-md-12">
	        <h1>Update Ad</h1>
		        <form name="updateAd" action="/HousingBoard/ads/update" method="post">
		        <table class="table">
		        <input type="hidden" name="id" value="<c:out value='${ads.id}' />" required/>   
		            <tr>
		                <th>Title: </th>
		                <td>
		                    <input class="form-control" type="text" name="title" size="45"
		                            value="<c:out value="${ads.title}" />"
		                       required />
		                </td>
		            </tr>
		            <tr>
		                <th>ImageUrl: </th>
		                <td>
		                    <input class="form-control" type="text" name="imageUrl" size="45"
		                            value="<c:out value="${ads.imageUrl}" />"
		                    required/>
		                </td>
		            </tr>
		            <tr>
		                <th>Description </th>
		                <td>
		                    <input class="form-control" type="text" name="description" size="45"
		                            value="<c:out value="${ads.description}" />"
		                    required/>
		                </td>
		            </tr>
		            <tr>
		                <th>Community </th>
		                <td>
		                    <input class="form-control" type="text" name="community" size="25"
		                            value="<c:out value='${ads.community}' />"
		                    required/>
		                </td>
		            </tr>
		                <th>Preferences </th>
		                <c:forEach var = "split" items = "${fn:split(ads.preferences, ',')}">
		                
		                <c:choose>
		                	<c:when test="${split == '1' }">
		                		<c:set var = "a"  value = "1"></c:set>
		                	</c:when>
		                	<c:when test="${split == '2' }">
		                		<c:set var = "b"  value = "2"></c:set>
		                	</c:when>
		                	<c:when test="${split == '3' }">
		                		<c:set var = "c"  value = "3"></c:set>
		                	</c:when>
		                </c:choose>
		                
		                </c:forEach>
		                <td>
		                <div class="form-check">
		                	<input class="form-check-input" type="checkbox" name="preferences" value="1"  ${a == '1' ? 'checked' : ''}>
		                	<label class="form-check-label">Parking Space</label>
		                </div>
		                <div class="form-check">
		                	<input class="form-check-input" type="checkbox" name="preferences" value="2"  ${b == '2' ? 'checked' : ''}>
		                	<label class="form-check-label">Gender Inclusive</label>
		                </div>
		    			<div class="form-check">
		    				<input class="form-check-input" type="checkbox" name="preferences" value="3"  ${c == '3' ? 'checked' : ''}>
		    				<label class="form-check-label">Pets Allowed</label>
		    			</div>
		    				
		                </td>
		            </tr>
		            	<th>Leasing Type </th>
		                <td>
		                <div class="form-check">
			                <input class="form-check-input" type="radio" name="leasingType" size="15" value="New Lease" ${ads.leaseType == 'New Lease' ? 'checked' : '' }/>
			                <label class="form-check-label">New Lease</label>
		                </div>
		                <div class="form-check">
			                <input class="form-check-input" type="radio" name="leasingType" size="15" value="Sub Lease" ${ads.leaseType == 'Sub Lease' ? 'checked' : '' }/>  
			                <label class="form-check-label">Sub Lease</label>
		                </div>
		                 
		                 
		                </td>
		            </tr>
		             <tr>
		                <th>Sharing</th>
		                <td>
		                    <select class="form-control" type="select" name="sharing" >
		                    <option  value="<c:out value="${ads.sharing}" />"  ${ads.sharing == "true" ? 'selected' : '' }>YES</option>
		                    <option  value="<c:out value="${ads.sharing}" />"  ${ads.sharing == "false" ? 'selected' : '' }>NO</option>
		                    </select>
		                </td>
		            </tr>
		            <tr>
		                <th>Apartment Type</th>
		                <td>               
		                    <select class="form-control" type="text" name="apartmentTypeId">
		                    	<option value = "1" ${ads.apartmentTypeId == '1' ? 'selected' : '' }>1BR</option>
		                    	<option value = "2" ${ads.apartmentTypeId == '2' ? 'selected' : '' }>2BR</option>
		                    	<option value = "3" ${ads.apartmentTypeId == '3' ? 'selected' : '' }>3BR</option>
		                    	<option value = "4" ${ads.apartmentTypeId == '4' ? 'selected' : '' }>Studio</option>
		                    	<option value = "5" ${ads.apartmentTypeId == '5' ? 'selected' : '' }>Duplex</option>
		                    	<option value = "6" ${ads.apartmentTypeId == '6' ? 'selected' : '' }>Penthouse</option>
		                    	<option value = "7" ${ads.apartmentTypeId == '7' ? 'selected' : '' }>Others</option>
		                    </select>
		                </td>
		            </tr>
		            <tr>
		                <td colspan="2" align="center">
		                    <input class="btn blue-sky" type="submit" value="Update"/>
		                </td>
		            </tr>
		        </table>
		        </form>
		    </div>
	    </div>
	    </div>
	    </div>   
</body>
</html>
