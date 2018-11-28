<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leasing Office - Home page</title>
<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 <!--  StyleSheet -->
<link rel="stylesheet" href="/HousingBoard/css/style.css"></link>
<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-light blue-sky">
    	<a class="navbar-brand text-white" href="#">
      		HousingBoard
    	</a>
  	</nav>
	<div class="container-fluid granite">
	  <div class="container">
	    <div class="row">
	      <div class="col-md-12">
	        <h2 class="text-center">Hello Leasing Office User - ${user.name},</h2>
        	<a class="btn blue-sky text-center" href="/HousingBoard/createAds.jsp">Create an AD</a>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Bootstrap JS  -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		
	Hello Leasing Office User - ${user.name},
	<br>
 	<c:if test="${user.pageFlag==0}">
	<a href="/HousingBoard/createPage.jsp">Create Leasing Office Page</a>
	<form action="/HousingBoard/updateprofile/dataretrieve" method="post">
     			<input type="submit" value="Update details" />
            </form>
	</c:if>
	<br/>	
	<c:if test="${user.pageFlag==1}">
	
	<a href="/HousingBoard/createAds.jsp">Create an AD</a>
	<form action="/HousingBoard/updateprofile/dataretrieve" method="post">
     			<input type="submit" value="Update details" />
            </form>
	</c:if>
</body>
</html>
