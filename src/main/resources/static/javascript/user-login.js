// For Regex
function validateEmail(){
    let format = ('[a-z0-9]+@[a-z]+\.[a-z]{2,3}')
    let em = document.getElementById("E-mail").value
    if(em.match(format)){
        return true
    }else{
        alert("Please enter valid email address")
    }
}

// For filling alerts
function fill(){
    let e = document.getElementById("E-mail").value
    let p = document.getElementById("Password").value
    if(e==""){
        alert("Please enter your email-address!!!")
    }else if(p==""){
        alert("please enter your password!!!")
    }else if(e=="" || p==""){
        alert("please fill all your details!!!")
    }else{
        alert("Welcome!!!")
    }
}
