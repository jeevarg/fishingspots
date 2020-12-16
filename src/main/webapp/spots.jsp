<%@ page import="com.fishingspots.utilities.PropertiesLoader" %>
<%@ page import="java.util.Properties" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <c:import url="metaInfo.jsp"/>
    <c:import url="title.jsp"/>
    <c:import url="styleSheet.jsp"/>
    <c:import url="styleSheetJQuery.jsp"/>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
    <script type="text/javascript" class="init">
        $(document).ready( function () {
            $('#userTable').DataTable();
        } );
    </script>


    <style type="text/css">
        table.table td a.add {
            color: #27C46B;
        }
        table.table td a.edit {
            color: #FFC107;
        }
        table.table td a.delete {
            color: #E34724;
        }
        table.table td i {
            font-size: 19px;
        }
    </style>

    <script defer>
        let map, marker;
        function initMap() {

            const options = {
                zoom:12,
                center:{lat:43.0731, lng:-89.4012},
            };

            map = new google.maps.Map(document.getElementById('map'), options);

            function addMarker(props){
                marker = new google.maps.Marker({
                    position:props.coords,
                    map:map,
                    title:'ID: ' + props.spotId + '; Name: ' + props.spotName,
                });
            }

            <c:if test="${requestScope.containsKey('spots')}">
                <c:if test="${requestScope.spots.size() != 0}">
                    <c:forEach var="spot" items="${spots}">
                        addMarker({
                            coords:{lat:${spot.lat},lng:${spot.lon}},
                            spotId:${spot.id},
                            spotName:'${spot.spotName}',
                        });
                    </c:forEach>
                </c:if>
            </c:if>
            <c:if test="${requestScope.spots.size() == 0}">
                alert("No spots found. Please increase your search radius or try another zip code");
            </c:if>
        }
    </script>
</head>

<body>
<!-- Header -->
<div class="w3-content" style="width:100%;height:100%">
        <c:import url="header.jsp"/>

    <div class="w3-container w3-light-gray w3-left w3-border" style="width:25%;height:70%">
        <!--div class="w3-panel w3-light-blue w3-round-xlarge" style="width:90%;height:90%"-->
        <h4>Enter a <b>ZipCode</b> and <b>Miles</b> to search for fishing spots within a radius</h4>
        <br>
        <form action="searchSpots" method="GET">
            <h4>ZipCode:</h4>
            <input class="w3-input w3-border" type="text" name="param1" value="" />
            <h4>Miles:</h4>
            <input class="w3-input w3-border" type="number" name="param2" value="" />
            <br>
            <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Search</button>
            <br><br>
        </form>
    </div>

    <div id="map" class="w3-container w3-right w3-border" style="width:75%;height:70%">
        <% PropertiesLoader loader = new PropertiesLoader(); %>
        <% Properties properties = loader.loadProperties(); %>
        <!--//src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxfLy10XWAiDUurS2MNHKaIs31WoDLvYY&libraries=drawing&callback=initMap">-->

        <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=<%=properties.getProperty("googleMapAPIKey")%>&libraries=drawing&callback=initMap">
        </script>
    </div>

    <div id="spots">
    <c:if test="${requestScope.containsKey('spots')}">
        <c:if test="${requestScope.spots.size() != 0}">
            <table id="userTable" class="w3-table-all w3-hoverable">
                <thead>
                    <th>ID</th>
                    <th>Spot Name</th>
                    <th>City</th>
                    <th>State</th>
                    <th>ZipCode</th>
                    <th>Lat</th>
                    <th>Lng</th>
                </thead>
                <tbody>
            <c:forEach var="spot" items="${spots}">
                <tr>
                    <td>${spot.id}</td>
                    <td>${spot.spotName}</td>
                    <td>${spot.city}</td>
                    <td>${spot.state}</td>
                    <td>${spot.zipCode}</td>
                    <td>${spot.lat}</td>
                    <td>${spot.lon}</td>
                    <td><a class='add' title="Add" data-toggle="tooltip" href="editSpot.jsp"><i class="material-icons" >&#xe146;</i></a>
                        <a class="edit" title="Edit" data-toggle="tooltip" href="editSpot?id=${user.id}"><i class="material-icons" >&#xE254;</i></a>
                        <a class="delete" title="Delete" data-toggle="tooltip" href="deleteSpot?id=${user.id}"><i class="material-icons" >&#xE872;</i></a></td>
                </tr>
            </c:forEach>
                </tbody>
            </tr>
            </table>

        </c:if>
    </c:if>
    </div>

    <!-- Footer -->
    <c:import url="footer.jsp"/>

</div>
</body>
</html>

