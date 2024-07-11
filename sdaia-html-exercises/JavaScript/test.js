function validateLogin(){
    let var1=document.getElementById("username").value.trim()
    let var2=document.getElementById("pass").value.trim()
    if(var1 === "admin" &&  var2 === "admin"){
        window.location.href = '01-welcome.html';
    }
    else{
        document.getElementById("fail").innerHTML= "Username or Password are not correct. Try Again";
    }
}