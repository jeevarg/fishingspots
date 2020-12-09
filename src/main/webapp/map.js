
function initMap(listener) {
    // Map options
    const options = {
    zoom:12,
    center:{lat:43.0731, lng:-89.4012}
    }

    // New map
    const map = new google.maps.Map(document.getElementById('map'), options);

    // TODO fix below code so you can add a marker on the map.
    //listen for click on map
 /*   google.maps.events.addListener(map, 'click',
    function(event){
    // add marker
    addMarker({coords:event.latlng});
}); */

    function addMarker(props) {
        const marker = new google.maps.Marker({
            position: props.coords,
            map: map,
        });

        if (props.content) {
            const infoWindow = new google.maps.InfoWindow({
                content: props.content
            });

            marker.addEventListener('click', function () {
                infoWindow.open(map, marker);
            });
        }
    }

    // Add marker
    addMarker({
        coords:{lat:48.0000, lng:-89.333291},
        content:'<h4>spot1</h4>'
    });

}
