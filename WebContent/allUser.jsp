<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <center>
        <h1>User Management</h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
            	<th>Id</th>
                <th>Name</th>
                <th>Email Id</th>
                <th>Phone Number</th>
<!--                 <th>Is Active</th> -->
                <th>Action</th>
            </tr>
            <c:forEach var="user" items="${listalluser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                 	<td><c:out value="${user.emailId}" /></td>
                    <td><c:out value="${user.phoneNumb}" /></td>
<%--                     <td><c:out value="${user.isActive}" /></td> --%>
                    <td>
                       <form action="/HousingBoard/admin/deleteUser?id=<c:out value="${user.id}" />" method="post">
     			<input type="submit" value="delete" />
            </form>               
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>