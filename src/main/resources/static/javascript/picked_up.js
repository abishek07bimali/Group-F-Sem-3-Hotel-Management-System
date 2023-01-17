var map;
var input = document.getElementById('locationInput');

map = new google.maps.Map(document.getElementById('map'), {
  center: {lat: -33.8688, lng: 151.2195},
  zoom: 13
});

var autocomplete = new google.maps.places.Autocomplete(input);
autocomplete.bindTo('bounds', map);

autocomplete.addListener('place_changed', function() {
    var place = autocomplete.getPlace();
    console.log(place);
});

var input = document.getElementById('location-input');
var autocomplete = new google.maps.places.Autocomplete(input);

autocomplete.addListener('place_changed', function() {
  var place = autocomplete.getPlace();
  if (!place.geometry) {
    // User entered the name of a Place that was not suggested and
    // pressed the Enter key, or the Place Details request failed.
    window.alert("No details available for input: '" + place.name + "'");
    return;
  }

  // If the place has a geometry, then present it on a map.
  if (place.geometry.viewport) {
    map.fitBounds(place.geometry.viewport);
  } else {
    map.setCenter(place.geometry.location);
    map.setZoom(17);  // Why 17? Because it looks good.
  }
  var marker = new google.maps.Marker({
    map: map,
    position: place.geometry.location
  });
});

function myMap() {
  var mapProp= {
    center:new google.maps.LatLng(51.508742,-0.120850),
    zoom:5,
  };
  var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
}

