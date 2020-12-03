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

    marker.addEventListener('click', function(){
    infoWindow.open(map, marker);
});
}
}
}
