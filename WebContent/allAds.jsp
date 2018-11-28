<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <center>
        <h1>Admin Ads</h1>
    </center>
    <div align="center">
        <table border="3" cellpadding="4">
            <caption><h2>List of All Ads</h2></caption>
            <tr>
            	<th>Id</th>
                <th>Title</th>
                <th>Image</th>
                <th>Description</th>
                <th>Community</th>
                <th>Action</th>
            </tr>
            <c:forEach var="ads" items="${AdminAdsList}">
                <tr>
                    <td><c:out value="${ads.id}" /></td>
                    <td><c:out value="${ads.title}" /></td>
                    <td><img src="<c:out value="${ads.imageUrl}"/>" alt="Showing Apartment" height="42" width="42"></td>
                    <td><c:out value="${ads.description}" /></td>
                    <td><c:out value="${ads.community}" /></td>
                    <td>
                    <form action="/HousingBoard/ads/delete?id=<c:out value="${ads.id}" />" method="post">
     			<input type="submit" value="delete" />
            </form>
<%--                         <a href="/HousingBoard/ads/delete?id=<c:out value="${ads.id}" />">Delete</a>                --%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>