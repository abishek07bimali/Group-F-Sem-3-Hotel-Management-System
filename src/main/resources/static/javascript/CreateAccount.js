// function validate()

// {

// var username=document.getElementById("user").value;

// var password=document.getElementById("pws").value;

//     if(username=="admin" && password=="admin" ){

//       window.location.assign("homepage.html");

//         alert("login succesfull");

     

//     }

//     else{

//         alert("Incorrect UserID or Password");

//     }

// }

var attempt = 3; // Variable to count number of attempts.

// Below function Executes on click of login button.
function validate(){
    var name = document.getElementById("name").value;
    var number = document.getElementById("number").value;
var email = document.getElementById("email").value;
var password = document.getElementById("password").value;

if ( name == "admin" && number=="admin"  &&  email=="admin" && password == "admin" ){

alert ("Account is created");

window.location = "p.html"; // Redirecting to other page.

return false;

}