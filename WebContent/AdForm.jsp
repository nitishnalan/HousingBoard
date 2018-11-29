<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
 function checkRequest(){
	//alert("checkRequest called : ");
	console.log("calling from checkRequest : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/checkAdRequest/reviewInterests";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}
 
 function updateProfile(){
		//alert("updateProfile called : ");
		console.log("calling from checkRequest : ");
		document.getElementById("memberDashboard").action = "/HousingBoard/updateprofile/dataretrieve";
		document.getElementById("memberDashboard").method = "POST";
		document.getElementById("memberDashboard").submit();
}
 
function redirectToDashBoard(){
		//alert("updateProfile called : ");
		console.log("calling from redirectToDashBoard : ");
		document.getElementById("memberDashboard").action = "/HousingBoard/redirect/dashBoard";
		document.getElementById("memberDashboard").method = "POST";
		document.getElementById("memberDashboard").submit();
}

function logOut(){
	//alert("updateProfile called : ");
	console.log("calling from logOut : ");
	document.getElementById("memberDashboard").action = "/HousingBoard/logOut";
	document.getElementById("memberDashboard").method = "POST";
	document.getElementById("memberDashboard").submit();
}
</script>
    <title>Ads Application</title>
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
      	<form id="memberDashboard"></form>
		<div class="col-md-12">
		<center>
		<form action="/HousingBoard/ads/listAds" method="post">
			<input class="btn blue-sky" type="submit" value="List of ADS" />
         </form>
        <h1>Ads Management</h1>
        
    </center>
    <div align="center">
    	<form action="/HousingBoard/ads/insert" method="post">

        <table class="table">
         	<c:if test="${ad != null}">
                    <input class="form-control" type="hidden" name="id" value="<c:out value='${ad.id}' />" />
          	</c:if>           
            <tr>
                <th>Title: </th>
                <td>
                    <input class="form-control" type="text" name="title" size="45"
                            value="<c:out value="${ads.title}" />"
                        />
                </td>
            </tr>
            <tr>
                <th>ImageUrl: </th>
                <td>
                    <input class="form-control" type="text" name="imageUrl" size="45"
                            value="<c:out value="${ads.imageUrl}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description </th>
                <td>
                    <input class="form-control" type="text" name="description" size="45"
                            value="<c:out value="${ads.description}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>Community </th>
                <td>
                    <input class="form-control" type="text" name="community" size="25"
                            value="<c:out value='${ads.community}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Preferences </th>
                <td>
                <div class="form-check">
                	<input class="form-check-input" type="checkbox" id="parking-Space" name="preferences" value="1">
                    <label class="form-check-label">Parking Space</label>
                </div>
                <div class="form-check">
                	<input class="form-check-input" type="checkbox" name="preferences" value="2">
                	<label class="form-check-label">Gender Inclusive</label>
                </div>
                <div class="form-check">
                	<input class="form-check-input" type="checkbox" id="pets" name="preferences" value="3">
                	<label class="form-check-label">Pets Allowed :</label>
                </div>
                </td>
            </tr>
              <tr>
                <th>Leasing Type </th>
                <td>
                <div class="form-check">
                	<input class="form-check-input"  type="radio" id="new-lease" name="leasingType" size="15" value="New Lease"/>
                    <label class="form-check-label">New Lease</label>
                </div>
                <div class="form-check">
                	<input class="form-check-input" type="radio" name="leasingType" size="15" value="Sub Lease"/>
                	<label class="form-check-label">Sub Lease</label>
                </div>  
                </td>
            </tr>
             <tr>
                <th>Sharing</th>
                <td>
                    <select class="form-control" type="select" name="sharing" >
                    <option id="shared"value="YES">YES</option>
                    <option value="NO">NO</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Apartment Type</th>
                <td>
                    <select class="form-control" type="text" name="apartmentTypeId">
                    	<option value = "1">1BR</option>
                    	<option id="2br" value = "2">2BR</option>
                    	<option value = "3">3BR</option>
                    	<option value = "4">Studio</option>
                    	<option value = "5">Duplex</option>
                    	<option value = "6">Penthouse</option>
                    	<option value = "7">Others</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input class="btn blue-sky" type="submit" id="submit-button" value="Add an AD" />
                </td>
            </tr>
        </table>
    	</form>
    </div>   
		</div>
		</div>
	</div>
  	</div>
    <!-- Bootstrap JS  -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
</body>
</html>
