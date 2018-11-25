<%@ page import = "java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!--  StyleSheet -->
<link rel="stylesheet" href="css/style.css"></link>
<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">

<title>HousingBoard Registration</title>

<script type="text/javascript">
function fetchAdDetails(adID){
	alert("fetchAdDetails called@ : " + adID);
	console.log("calling from fetchAdDetails : " + adID);
	//console.log("/apnidukaan/product/search/1?categoryId="+categoryRequestedHome+"&searchfield="+searchCriteriaHome);
	document.getElementById("search").action = "/HousingBoard/adDetails/"+adID;
	document.getElementById("search").method = "POST";
	document.getElementById("search").submit();
}
</script>
<title>Search Results</title>
</head>
<body>

  <nav class="navbar navbar-light blue-sky">
    <a class="navbar-brand text-white" href="#">
      HousingBoard
    </a>
  </nav>
<!-- 	<form name="search" id="search" action = "/HousingBoard/searchAds/1" method="get">
		Apply Filters
		
		<button type ='submit' class='btn'>Apply Filters on Ads!</button>	
	</form> -->
  <div class="container-fluid granite">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h2>Search Ads</h2>
            <form name="search" id="search" action = "/HousingBoard/searchAds/1" method="get">
              <div class="form-row">

                <div class="form-group col-md-11">
                  <%
                    if(session.getAttribute("searchField") != null){
                      String searchFieldValue = (String) session.getAttribute("searchField");
                      out.print("<input type ='text'  class='form-control' name='searchfield' placeholder='Search Ads' value="+searchFieldValue+" required />");
                    }else
                    {
                      out.print("<input type ='text' class='form-control' name='searchfield' required/>");
                    }
                  %>
                </div>
                <div class="form-group col-md-1"><button type ='submit' class='btn blue-sky'>Search</button></div>
              </div>
              
              <div class="form-row">
                <div class="form-group col-md-3">
                    <label>Leasing Type</label>
                  <div class="form-check">
                      <input class="form-check-input" type="radio" name="leasingType" value="New Lease" /> 
                      <label class="form-check-label">New Lease</label>
                  </div>
                  <div class="form-check">
                      <input class="form-check-input" type="radio" name="leasingType" value="Sub Lease"/>
                      <label class="form-check-label">Sub Lease</label>
                  </div>
                </div>
                <div class="form-group col-md-3">
                    <label>Preferences</label>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="preferences" value="1" /> 
                      <label class="form-check-label">Parking Space Included</label>
                  </div>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="preferences" value="2" /> 
                      <label class="form-check-label">Gender Inclusive</label>
                  </div>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="preferences" value="3" />
                      <label class="form-check-label"> Pets Allowed</label>
                  </div>
                </div>
                <div class="form-group col-md-2">
                  <label>Sharing</label>
                  <div class="form-check">  
                    <input class="form-check-input" type="checkbox" name="nonsharing" value="true"> 
                    <label class="form-check-label">Non-Sharing</label>
                  </div>
                </div>
                <div class="form-group col-md-3">
                  <label>Apartment Type</label>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="apartmentType" value="1"> 
                      <label class="form-check-label">1BR</label>
                  </div>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="apartmentType" value="2">
                      <label class="form-check-label">2BR</label>
                  </div>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="apartmentType" value="3">
                      <label class="form-check-label">3BR</label>
                  </div>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="apartmentType" value="4"> 
                      <label class="form-check-label">Studio</label>
                  </div>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="apartmentType" value="5"> 
                      <label class="form-check-label">Duplex</label>
                  </div>
                  <div class="form-check">
                      <input class="form-check-input" type="checkbox" name="apartmentType" value="6"> 
                      <label class="form-check-label">Penthouse</label>
                  </div>
                </div>  
                <div class="col-md-1">
                    <button class="btn blue-sky" type ='submit'>Apply</button>	
                </div>
              </div>
              
              
              <table class="table table-bordered table-responsive" border=1>
                <c:forEach items="${searchResultsOfAds}" var="adPost">
                  <c:choose>
                    <c:when test="${adPost.isAvailable() eq true}">
                      <tr>
                        <td> ${adPost.id}</td>
                        <td> ${adPost.title}</td>
                      <%-- 	<td> <img width=src="${adPost.imageUrl}"></td> --%>
                        
                        <td> <img src="${adPost.imageUrl}" alt="Smiley face" width="42" height="42" /></td>
                        <td> ${adPost.userId}</td>
                        <td> ${adPost.description}</td>
                        <td> ${adPost.community}</td>
                        <td> <a href='#' onclick="fetchAdDetails(${adPost.id});"> Click here for Details </a> </td>
                      </tr>
                    </c:when>
                    
                    <c:otherwise>
                      <tr>
                        <td> ${adPost.id}</td>
                        <td> ${adPost.title}</td>
                        <td> <img src="${adPost.imageUrl}" alt="Smiley face" width="500" height="500" /></td>
                        <td> ${adPost.userId}</td>
                        <td> ${adPost.description}</td>
                        <td> ${adPost.community}</td>
                        <td> <a href='#' onclick="fetchAdDetails(${adPost.id});"> Click here for Details </a> </td>
                      </tr>
                    </c:otherwise>
                  </c:choose>
                  
                </c:forEach>
              </table>
                <%
                  if(session.getAttribute("searchField") != null){
                    String searchFieldValue = (String) session.getAttribute("searchField");
                    int pageCounter = (int)session.getAttribute("totalPages");
                    StringBuilder strBuild = new StringBuilder();
                    
                    int pageNo = 1;
                    
                    while(pageCounter!=0){
                      //strBuild.append("<li><a href='/apnidukaan/product/search/"+pageNo+"?categoryId="+searchFieldValue+"&searchfield="+searchFieldValue+"' class='btn btn-warning'>	"+pageNo+"</a></li> &nbsp");
                      //strBuild.append("<li><a href='/HousingBoard/searchAds/"+pageNo+"?searchfield="+searchFieldValue+"'> "+pageNo+"</a></li> &nbsp");
                      
                      strBuild.append("<a href='/HousingBoard/searchAds/"+pageNo+"?searchfield="+searchFieldValue+"'> "+pageNo+"</a> &nbsp");
                      ++pageNo;
                      --pageCounter;
                    }
                    
                    //out.print("<ul class='pagination'>");
                    out.print(strBuild.toString());
                    //out.print("</ul>");
                  }
                %>
          
            </form>
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