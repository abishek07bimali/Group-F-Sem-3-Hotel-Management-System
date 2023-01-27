    $(document).ready(function(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    today = yyyy + '-' + mm + '-' + dd;
    document.getElementById("checkInDate").setAttribute("min", today);
    document.getElementById("checkOutDate").setAttribute("min", today);
});
