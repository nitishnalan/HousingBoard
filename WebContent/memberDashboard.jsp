<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member - Home Page</title>
</head>
<body>
<h1>Your User Details are as follows:-</h1>

${user.name}

<a href="${user}"></a>
<br/><br/><br/><br/>
<a href="editform.jsp">Update Details</a><br/><br/><br/>

<a href ="AdForm.jsp">Manage Ads</a><br/><br/><br/>

</form>
</body>
</html>