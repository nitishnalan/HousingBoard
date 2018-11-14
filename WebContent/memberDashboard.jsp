<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member - Home Page</title>
</head>
<body>
<br/><br/><br/><br/>
<h2>Welcome ${user.name}</h2>
<h3>You can manage your account and ads using the link below</h3>
<table>
<tr>
<td>
<h4><a href="editform.jsp"><button>Update Details</button></a></h4><br/><br/>
</td>
<td>
<h4><a href ="AdForm.jsp"><button>Manage Ads</button></a></h4><br/><br/>
</td>
</tr>
</table>
</form>
</body>
</html>