<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
</head>
<body>
<h1>AD Updated Successfully</h1>
<h5>The user who deleted the ad is as follows</h5>
<label>Update By:</label><p>${user.name}</p>
<h5>Please Go To The list of ads to and refresh the page to view current ads/h5>
<a href="AdList.jsp">Back to List of Ads</a>
</body>
</html>