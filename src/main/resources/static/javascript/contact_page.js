function submitMessage(){
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
