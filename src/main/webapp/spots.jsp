<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 11/7/20
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Fishing Spots</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://maps.googleapis.com/maps/api/js"></script>
    <style>
        #map {
            height: 100%;
        }
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>

    <script>
        function initMap(listener) {
            // Map options
            var options = {
                zoom:12,
                center:{lat:43.0731, lng:-89.4012}
            }

            // New map
            var map = new google.maps.Map(document.getElementById('map'), options);

            // TODO fix below code so you can add a marker on the map.
            //listen for click on map
            google.maps.addEventListener(map, 'click',
                function(event){
                    // add marker
                    addMarker({coords:event.latlng});
                });

            addMarker({
                coords:{lat:43.071877, lng:-89.333291},
                icon:"/images/goldfish.png",
                content:'<h4>spot1</h4>'
            });

            // Add marker
            function addMarker(props){
                var marker = new google.maps.Marker({
                    position:props.coords,
                    map:map,

                });

                if(props.icon){
                    marker.setIcon(props.icon);
                }

                if(props.content){
                    var infoWindow = new google.maps.InfoWindow({
                        content:props.content
                    });

                    marker.addEventListener()('click', function(){
                        infoWindow.open(map, marker);
                    });
                }
            }
        }
    </script>
</head>
<body>

<!-- w3-content defines a container for fixed size centered content,
and is wrapped around the whole page content, except for the footer in this example -->


<!-- Header -->
<div class="w3-content" style="width:100%;height:100%">
    <header class="w3-container w3-blue-gray">
        <h1> <b> Fishing Spots </b>
            <img src="fishing.png" alt="Image" class="w3-left w3-margin-right" style="width:100px">
        </h1>
        <button class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">Home</button>
        <button class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">Spots</button>
        <button class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">Login</button>
        <button class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">About</button>
    </header>


    <div class="w3-container w3-light-gray w3-left w3-border" style="width:25%;height:100%">
        <!--div class="w3-panel w3-light-blue w3-round-xlarge" style="width:90%;height:90%"-->
        <h4>Enter a <b>ZipCode</b> and <b>Miles</b> to search for fishing spots within a radius</h4>
        </br>
        <form action="searchUserByLastName" method="GET">
            <h4>ZipCode:</h4>
            <input class="w3-input w3-border" type="text" name="param1" value="" />
            <h4>Miles:</h4>
            <input class="w3-input w3-border" type="number" name="param2" value="" />
            </br>
            <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Search</button>
            </br></br>
        </form>

    </div>

    <div id="map" class="w3-container w3-right w3-border" style="width:75%;height:100%">

        <script defer
                src="https://maps.googleapis.com/maps/api/js?key=<ENTER A VALID KEY>">
        </script>
    </div>


    <!-- Footer -->
    <footer class="w3-container w3-blue-grey w3-margin-top">
        <p>Fishing Spots 2020 by Jeeva Gulli</p>
    </footer>

</div>
</body>
</html>

