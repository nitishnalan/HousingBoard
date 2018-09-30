<%@ page import = "java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<form name="search" id="search" action = "/HousingBoard/searchAds" method="get"> 
		<p>Enter Text you would like to Search: </p>
		<input class="form-control" type ="text" name="searchfield">
		<button type ='submit' class='btn'>Search Ads!</button>	
	</form>
	
	<form name="searchResults" id="searchResults" action = "" method="get">
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
						</tr>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
		</table>
	</form>
</body>
</html>