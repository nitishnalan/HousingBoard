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
    <br/><br/>
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
                    <label>Parking Space Included :</label><input type="checkbox" name="preferences" value="1"><br/>
    				<label>Gender Inclusive :</label><input type="checkbox" name="preferences" value="2"><br/>
    				<label>Pets Allowed :</label><input type="checkbox" name="preferences" value="3"><br/>
                </td>
            </tr>
              <tr>
                <th>Leasing Type </th>
                <td>
                 <label>New Lease :</label><input type="radio" name="leasingType" size="15"
                            value="New Lease"/><br/><br/>
                 <label>Sub Lease :</label><input type="radio" name="leasingType" size="15"
                            value="Sub Lease"/><br/><br/>   
                </td>
            </tr>
             <tr>
                <th>Sharing</th>
                <td>
                    <select type="select" name="sharing" >
                    <option value="YES">YES</option>
                    <option value="NO">NO</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Apartment Type</th>
                <td>
                    <select type="text" name="apartmentTypeId">
                    	<option value = "1">1BR</option>
                    	<option value = "2">2BR</option>
                    	<option value = "3">3BR</option>
                    	<option value = "4">Studio</option>
                    	<option value = "5">Duplex</option>
                    	<option value = "6">Penthouse</option>
                    	<option value = "7">Others</option>
                    </select>
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
