<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <c:import url="title.jsp"/>
    <c:import url="metaInfo.jsp"/>
    <c:import url="styleSheet.jsp"/>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
    <script type="text/javascript">
        <c:import url="map.js"/>
    </script>
</head>

<body>
<!-- Header -->
<div class="w3-content" style="width:100%;height:100%">
        <c:import url="header.jsp"/>

    <div class="w3-container w3-light-gray w3-left w3-border" style="width:25%;height:70%">
        <!--div class="w3-panel w3-light-blue w3-round-xlarge" style="width:90%;height:90%"-->
        <h4>Enter a <b>ZipCode</b> and <b>Miles</b> to search for fishing spots within a radius</h4>
        </br>
        <form action="searchSpots" method="GET">
            <h4>ZipCode:</h4>
            <input class="w3-input w3-border" type="text" name="param1" value="" />
            <h4>Miles:</h4>
            <input class="w3-input w3-border" type="number" name="param2" value="" />
            </br>
            <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Search</button>
            </br></br>
        </form>
    </div>

    <div id="map" class="w3-container w3-right w3-border" style="width:75%;height:70%">
        <script defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTjOH-2jJDtCvlFJaxaTJRKQniaw6Jslo&libraries=drawing&callback=initMap">
        </script>
    </div>

    <div id="spots">
        <c:if test="${requestScope.containsKey('spots')}">
            ${requestScope.spots}
        </c:if>
    </div>

    <!-- Footer -->
    <c:import url="footer.jsp"/>

</div>
</body>
</html>

