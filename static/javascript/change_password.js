function confirm(){
    let cp = document.getElementById("Current Password").value
    let n = document.getElementById("New Password").value
    let cn = document.getElementById("Confirm New Password").value
    if(cp==""){
        alert("Please enter your current password!!!")
    }else if(n==""){
        alert("please enter your new password!!!")
    }else if(cn==""){
        alert("please enter your confirm new password!!!")
    }else if(!n.match(cn)){
        alert("Your password didnot match!!!")
    }else{
        alert("Successfully Changed!!!")
    }
}