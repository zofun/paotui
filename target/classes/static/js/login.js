//根据此布尔值判断当前为注册状态还是登录状态
var onoff = true;
var confirm = document.getElementsByClassName("confirm")[0];
var username = document.getElementById("username");
var password = document.getElementById("password");
//var con_pass = document.getElementById("confirm-passwd")


//引用hint()在最上方弹出提示


//回调函数
/*function submit(callback) {
    //if (passwd.value == con_pass.value) {
    let request = new XMLHttpRequest()
    let url = ""
    request.open("post", url, true)
    let data = new FormData()
    data.append("user", user.value)
    data.append("passwd", passwd.value)
    request.onreadystatechange = function() {
        if (this.readyState == 4) {
            callback.call(this, this.response)
            //console.log(this.responseText)
        }
    }
    request.send(data)
}*/
/*else {
           hit.innerHTML = "两次密码不同"
           hitting()
       }
   }*/
//注册按钮
function signin() {
    let status = document.getElementById("status").getElementsByTagName("i")
    let hit = document.getElementById("hint").getElementsByTagName("p")[0]
    if (onoff) {
        confirm.style.height = 51 + "px"
        status[0].style.top = 35 + "px"
        status[1].style.top = 0;
        onoff = !onoff
    } else {
        if (!/^[A-Za-z0-9]+$/.test(username.value))
            hit.innerHTML = "账号只能为英文和数字"
        else if (username.value.length < 6)
            hit.innerHTML = "账号长度必须大于6位"
        else if (password.value.length < 6)
            hit.innerHTML = "密码长度必须大于6位"
        else  {
                    hit.innerHTML = "账号注册成功，两秒后自动刷新页面"
                    setTimeout("window.location.reload()", 2000);
        }
        hint();
    }
}

//登录按钮
function login() {
    if (onoff) {
        /*let request = new XMLHttpRequest()
        let url = ""
        request.open("post", url, true)
        let data = new FormData()
        data.append("user", user.value)
        data.append("passwd", passwd.value)
        request.onreadystatechange = function() {
            if (this.readyState == 4) {
                if (this.responseText == false)
                    hint()
                else
                    window.location.href = this.responseText;
            }
        }
        request.send(data)*/
    } else {
        let status = document.getElementById("status").getElementsByTagName("i")
        confirm.style.height = 0;
        status[0].style.top = 0;
        status[1].style.top = 35 + "px";
        onoff = !onoff
    }
}
