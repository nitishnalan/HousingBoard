<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ads Application</title>
</head>
<body>
	<h1>All Ads Have Been Updated and New Ads Have been Posted</h1>
	<h5>If you want to add some more adds please click the back button</h5><br/>
<form name="search" id="search" action = "/HousingBoard/ads/*" method="get"> 
    <div align="center">
        <table border="1" cellpadding="5">
         <caption><h2>List of Ads</h2></caption>
            <tr>
            	<th>Id</th>
                <th>Title</th>
                <th>Image</th>
                <th>Description</th>
                <th>Community</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="ads" items="${listAds}">
                <tr>
                    <td><c:out value="${ads.id}" /></td>
                    <td><c:out value="${ads.title}" /></td>
                    <td><img src="<c:out value="${ads.imageUrl}" />" alt="Showing Apartment" height="150" width="150"></td>                    
                    <td><c:out value="${ads.description}" /></td>
                    <td><c:out value="${ads.community}" /></td>
                    <td>
<%--                      <form action="/HousingBoard/ads/delete?id=<c:out value="${ads.id}" />" method="post">
						<input type="submit" value="Delete Your AD" />
         			</form> --%>
         			<a href='#' onclick="deleteAds(${ads.id});">Delete Ad</a>
					<a href='#' onclick="updateAds(${ads.id});">Update Ad</a>
         			<br/><br/>
         			&nbsp;&nbsp;&nbsp;&nbsp;
         			<%-- <a href="/HousingBoard/ads/edit?id=<c:out value="${ads.id}" />" >Edit Your AD</a><br/><br/> --%>
<%--          			<form action="/HousingBoard/ads/edit?id=<c:out value="${ads.id}" />" method="post">
						<input type="submit" value="UPDATE Your AD" />
         			</form> --%>
         		<!-- 	<input type = "button" name = "Delete" -->
         		
         		<!-- Call in Get Method  -->
<%--          				<a href="<c:url value="/HousingBoard/ads/delete?id=${ads.id}" />">Delete</a>
            			<a href="<c:url value="/HousingBoard/ads/update?id=${ads.id}" />">Edit</a>
 --%>               
<%--  					<input type = "button" value = "DELETE AD"  id = "${ads.id}" onclick = "deleteAd(this.id);"/>	
 					<input type = "button" value = "UPDATE AD" id = "${ads.id}"  onclick = "updateAd(this.id);"/>
 				 --%>	
 					</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>   
</body>
<script type="text/javascript">
function deleteAds(adID){
	alert("fetchAdDetails called@ : " + adID);
	console.log("calling from Delete Ad : " + adID);
	document.getElementById("search").action = "/HousingBoard/ads/delete?id="+adID;
	document.getElementById("search").method = "POST";
	document.getElementById("search").submit();
}

function updateAds(adID){
	alert("fetchAdDetails called@ : " +adID);
	console.log("calling from Update Ad : " + adID);
	document.getElementById("search").action = "/HousingBoard/ads/edit?id="+adID;
	document.getElementById("search").method = "POST";
	document.getElementById("search").submit();
}
</script>
</html>