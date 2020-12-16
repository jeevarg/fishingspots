<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <c:import url="metaInfo.jsp"/>
    <c:import url="title.jsp"/>
    <c:import url="styleSheet.jsp"/>
    <c:import url="styleSheetJQuery.jsp"/>

</head>>
<body>
<div class="w3-content" style="width:100%;height:100%">
    <c:import url="header.jsp"/>
        <div class="w3-container w3-light-gray w3-left w3-border" style="width:25%;height:70%">
            <h2>Add/Edit Spot</h2><br/>
    <form action="editSpot" method="POST">

        <input type="hidden" id="id" name="id" value = ${spot.id}>
        Spot Name: <input type="text" id="spotName" name="spotName" value = "${spot.spotName}">
        City: <input type="text" id="city" name="city" value = "${spot.city}">
        State: <input type="text" id="state" name="State" value = "${spot.state}">
        Zip Code: <input type="text" id="zipCode" name="zipCode" value = "${spot.zipCode}">
        Lat: <input type="text" id="lat" name="lat" value = "${spot.lat}">
        Lat: <input type="text" id="lon" name="lon" value = "${spot.lon}">
        <button type="submit" class="btn btn-default col-sm-offset-3"
                data-disable="true">Add
        </button>
        <button type="reset" class="btn btn-default">Clear</button>

    </form>
</div>
    <c:import url="footer.jsp"/>
</div>
</body>
</html>
