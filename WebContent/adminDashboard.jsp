<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Admin</title>
</head>
<body>
<form action="/HousingBoard/admin/listalluser" method="post">
     			<input type="submit" value="All Users" />
            </form>
<form action="/HousingBoard/ads/AdminlistAds" method="post">
     			<input type="submit" value="All Ads" />
            </form>
<a href="searchAds.jsp"><button type="button">Search Ads</button></a>
</body>
</html>