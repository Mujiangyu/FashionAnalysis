function userLogin() {
    document.getElementById("regist").style.display = "none";
    document.getElementById("resetpwd").style.display = "none";
    document.getElementById("login").style.display = "block";
}

function userRegist() {
    document.getElementById("login").style.display = "none";
    document.getElementById("resetpwd").style.display = "none";
    document.getElementById("regist").style.display = "block";
}

function userReset() {
    document.getElementById("login").style.display = "none";
    document.getElementById("regist").style.display = "none";
    document.getElementById("resetpwd").style.display = "block";
}


//查看验证问题
/*function showQuestion(str) {
    if (str=="") {
        document.getElementById("txtHint").innerHTML="";
        return;
    }
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    } else { // code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function() {
        if (this.readyState==4 && this.status==200) {
            document.getElementById("txtHint").innerHTML=this.responseText;
        }
    }
    xmlhttp.open("GET","/javascript/getQuestion.php?q="+str,true);
    xmlhttp.send();
}*/









