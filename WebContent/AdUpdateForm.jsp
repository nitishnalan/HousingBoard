<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ads Application</title>
</head>
<body>
    <center>
        <h1>Update Ads here</h1><br/><br/>
        <h3>Please make sure to enter all fields</h3><br/><br/>
    </center>
    <div align="center">
        <form action="/HousingBoard/ads/update" method="post" required>
        <table border="1" cellpadding="5">
        <input type="hidden" name="id" value="<c:out value='${ads.id}' />" required/>   
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value="${ads.title}" />"
                       required />
                </td>
            </tr>
            <tr>
                <th>ImageUrl: </th>
                <td>
                    <input type="text" name="imageUrl" size="45"
                            value="<c:out value="${ads.imageUrl}" />"
                    required/>
                </td>
            </tr>
            <tr>
                <th>Description </th>
                <td>
                    <input type="text" name="description" size="45"
                            value="<c:out value="${ads.description}" />"
                    required/>
                </td>
            </tr>
            <tr>
                <th>Community </th>
                <td>
                    <input type="text" name="community" size="25"
                            value="<c:out value='${ads.community}' />"
                    required/>
                </td>
            </tr>
            <tr>
                <th>preferences</th>
                <td>
                    <input type="text" name="preferences" size="15"
                            value="<c:out value="${ads.preferences}" />"
                   required />
                </td>
            </tr>
              <tr>
                <th>leasingtype </th>
                <td>
                    <input type="text" name="leasingType" size="15"
                            value="<c:out value="${ads.leasingType}" />"
                    required/>
                </td>
            </tr>
             <tr>
                <th>Sharing</th>
                <td>
                    <select type="select" name="sharing" size="5"
                            value="<c:out value="${ads.sharing}" />" required>
                    <option>YES</option>
                    <option>NO</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Apartment ID</th>
                <td>
                    <input type="text" name="apartmentTypeId" size="15"
                            value="<c:out value="${ads.apartmentTypeId}" />" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update AD"/>
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
