<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.housingboard.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leasing Office - Home page</title>
</head>
<body>
		
	Hello Leasing Office User - ${user.name},
	
	<br/>	
	If you would like to created an Ad please click this button: <a href="/HousingBoard/createAds.jsp">Create an AD</a>
	
</body>
</html>