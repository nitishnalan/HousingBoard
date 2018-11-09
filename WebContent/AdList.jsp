<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ads Application</title>
</head>
<body>
    <center>
        <h1>Ads Management</h1>
        <h2>
            <!--<a href="/HousingBoard/ads/new">Add new ad</a>
            &nbsp;&nbsp;&nbsp;
                          <a href="/HousingBoard/ads/list">List All Ads</a>
       -->
   
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Ads</h2></caption>
            <tr>
            	<th>Id</th>
                <th>Title</th>
                <th>Image</th>
                <th>Description</th>
                <th>Community</th>
<!--                 <th>Preference</th> -->
<!--                 <th>Leasing Type</th> -->
<!--                 <th>Sharing</th> -->
<!--                 <th>ApartmentTypeId</th> -->
                <th>Actions</th>
            </tr>
            <c:forEach var="ads" items="${listAds}">
                <tr>
                    <td><c:out value="${ads.id}" /></td>
                    <td><c:out value="${ads.title}" /></td>
                    <td><img src="<c:out value="${ads.imageUrl}" />" alt="Showing Apartment" height="42" width="42"><c:out value="${ads.imageUrl}" /></td>
                    
                    <td><c:out value="${ads.description}" /></td>
                    <td><c:out value="${ads.community}" /></td>
<%--                     <td><c:out value="${ads.preferences}" /></td> --%>
<%--                     <td><c:out value="${ads.leasingtype}" /></td> --%>
<%--                     <td><c:out value="${ads.sharing}" /></td> --%>
<%--                     <td><c:out value="${ads.apartmentTypeId}"/></td> --%>
                    <td>
                        <a href="/HousingBoard/ads/edit?id=<c:out value="${ads.id}" />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/HousingBoard/ads/delete?id=<c:out value="${ads.id}" />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>