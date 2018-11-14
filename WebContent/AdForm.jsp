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
        <form action="/HousingBoard/ads/listAds" method="post">
			<input type="submit" value="List of ADS" />
         </form>
    </center>
    <div align="center">
    	<form action="/HousingBoard/ads/insert" method="post">

        <table border="1" cellpadding="5">
         	<c:if test="${ad != null}">
                    <input type="hidden" name="id" value="<c:out value='${ad.id}' />" />
          	</c:if>           
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value="${ads.title}" />"
                        />
                </td>
            </tr>
            <tr>
                <th>ImageUrl: </th>
                <td>
                    <input type="text" name="imageUrl" size="45"
                            value="<c:out value="${ads.imageUrl}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description </th>
                <td>
                    <input type="text" name="description" size="45"
                            value="<c:out value="${ads.description}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>Community </th>
                <td>
                    <input type="text" name="community" size="25"
                            value="<c:out value='${ads.community}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>preferences </th>
                <td>
                    <input type="text" name="preferences" size="15"
                            value="<c:out value="${ad.preferences}" />"
                    />
                </td>
            </tr>
              <tr>
                <th>leasingtype </th>
                <td>
                    <input type="text" name="leasingtype" size="15"
                            value="<c:out value="${ads.leasingtype}" />"
                    />
                </td>
            </tr>
             <tr>
                <th>Sharing</th>
                <td>
                    <select type="select" name="sharing" size="5"
                            value="<c:out value="${ads.sharing}" />">
                    <option>YES</option>
                    <option>NO</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Apartment ID</th>
                <td>
                    <input type="text" name="apartmentTypeId" size="15"
                            value="<c:out value="${ads.apartmentTypeId}" />" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Add an AD" />
                </td>
            </tr>
        </table>
    	</form>
    </div>   
</body>
</html>
