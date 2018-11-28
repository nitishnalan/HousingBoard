<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ads Application</title>
</head>
<body>
    <center>
        <h1>Update Ads here</h1><br/><br/>
        <h3>Please make sure to enter all fields</h3><br/><br/>
         <br/><br/>
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
                <th>preferences </th>
                <c:forEach var = "split" items = "${fn:split(ads.preferences, ',')}">
                
                <c:choose>
                	<c:when test="${split == '1' }">
                		<c:set var = "a"  value = "1"></c:set>
                	</c:when>
                	<c:when test="${split == '2' }">
                		<c:set var = "b"  value = "2"></c:set>
                	</c:when>
                	<c:when test="${split == '3' }">
                		<c:set var = "c"  value = "3"></c:set>
                	</c:when>
                </c:choose>
                
                </c:forEach>
                <td>
                    <label>Parking Space Included :</label><input type="checkbox" name="preferences" value="1"  ${a == '1' ? 'checked' : ''}><br/>
    				<label>Gender Inclusive :</label><input type="checkbox" name="preferences" value="2"  ${b == '2' ? 'checked' : ''}><br/>
    				<label>Pets Allowed :</label><input type="checkbox" name="preferences" value="3"  ${c == '3' ? 'checked' : ''}><br/>
                </td>
            </tr>
            	<th>Leasing Type </th>
                <td>
                 <label>New Lease :</label><input type="radio" name="leasingType" size="15"
                            value="New Lease" ${ads.leaseType == 'New Lease' ? 'checked' : '' }/><br/><br/>
                 <label>Sub Lease :</label><input type="radio" name="leasingType" size="15"
                            value="Sub Lease" ${ads.leaseType == 'Sub Lease' ? 'checked' : '' }/><br/><br/>   
                </td>
            </tr>
             <tr>
                <th>Sharing</th>
                <td>
                    <select type="select" name="sharing" >
                    <option  value="<c:out value="${ads.sharing}" />"  ${ads.sharing == "true" ? 'selected' : '' }>YES</option>
                    <option  value="<c:out value="${ads.sharing}" />"  ${ads.sharing == "false" ? 'selected' : '' }>NO</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Apartment Type</th>
                <td>               
                    <select type="text" name="apartmentTypeId">
                    	<option value = "1" ${ads.apartmentTypeId == '1' ? 'selected' : '' }>1BR</option>
                    	<option value = "2" ${ads.apartmentTypeId == '2' ? 'selected' : '' }>2BR</option>
                    	<option value = "3" ${ads.apartmentTypeId == '3' ? 'selected' : '' }>3BR</option>
                    	<option value = "4" ${ads.apartmentTypeId == '4' ? 'selected' : '' }>Studio</option>
                    	<option value = "5" ${ads.apartmentTypeId == '5' ? 'selected' : '' }>Duplex</option>
                    	<option value = "6" ${ads.apartmentTypeId == '6' ? 'selected' : '' }>Penthouse</option>
                    	<option value = "7" ${ads.apartmentTypeId == '7' ? 'selected' : '' }>Others</option>
                    </select>
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
