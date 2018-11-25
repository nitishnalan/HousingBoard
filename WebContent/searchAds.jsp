<%@ page import = "java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<!-- 	<form name="search" id="search" action = "/HousingBoard/searchAds/1" method="get">
		Apply Filters
		
		<button type ='submit' class='btn'>Apply Filters on Ads!</button>	
	</form> -->

	<form name="search" id="search" action = "/HousingBoard/searchAds/1" method="get"> 
	
		Apply Filters
		
		<br/>
		Leasing Type
			<br/>
			<input type="radio" name="leasingType" value="New Lease"> New Lease<br>
  			<input type="radio" name="leasingType" value="Sub Lease"> Sub Lease<br>
  			
  		Preferences
  			<br/>
  			<input type="checkbox" name="preferences" value="1"> Parking Space Included<br>
  			<input type="checkbox" name="preferences" value="2"> Gender Inclusive<br>
  			<input type="checkbox" name="preferences" value="3"> Pets Allowed<br>

		Sharing
  			<br/>
  			<input type="checkbox" name="nonsharing" value="true"> Non-Sharing<br>
		
		  		
  		Apartment Type
  			<br/>
  			<input type="checkbox" name="apartmentType" value="1"> 1BR<br>
  			<input type="checkbox" name="apartmentType" value="2"> 2BR<br>
  			<input type="checkbox" name="apartmentType" value="3"> 3BR<br>
  			<input type="checkbox" name="apartmentType" value="4"> Studio<br>
  			<input type="checkbox" name="apartmentType" value="5"> Duplex<br>
  			<input type="checkbox" name="apartmentType" value="6"> Penthouse<br>

		<button type ='submit' class='btn'>Apply Filters on Ads!</button>	
		<br/>
		--------------------------------------------------------------------
	
		<p>Enter Text you would like to Search: </p>
		<%
			if(session.getAttribute("searchField") != null){
				String searchFieldValue = (String) session.getAttribute("searchField");
				out.print("<input type ='text'  class='form-control' name='searchfield' value="+searchFieldValue+" required>");
			}else
			{
				out.print("<input type ='text' class='form-control' name='searchfield' required/>");
			}
		
		%>
		<!-- <input class="form-control" type ="text" name="searchfield"> -->
		<button type ='submit' class='btn'>Search Ads!</button>	
	<!-- </form>
	
	<form name="searchResults" id="searchResults" action = "" method="get"> -->
		<table border=1>
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
</body>
</html>