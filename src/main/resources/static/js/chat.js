// 发送信息
function SendMsg()
{
    var text = document.getElementById("text");
    if (text.value == "" || text.value == null)
    {
        alert("发送信息为空，请输入！")
    }
    else
    {
        AddMsg('default', SendMsgDispose(text.value));
        text.value = "";
    }
}
// 发送的信息处理
function SendMsgDispose(detail)
{
    detail = detail.replace("\n", "<br>").replace(" ", "&nbsp;");
    return detail;
}

// 增加信息
function AddMsg(user,content,time)
{
    var str = CreadMsg(user, content,time);
    var msgs = document.getElementById("msgs");
    msgs.innerHTML = msgs.innerHTML + str;
}

// 生成内容
function CreadMsg(user, content,time)
{
    var str = "";
    if(user == 'default')
    {
        str = "<div class=\"msg guest\"><div class=\"msg-right\"><div class=\"msg-host headDefault\"></div><div class=\"msg-ball\" title="+time+">" + content +"</div></div></div>"
    }
    else
    {
        str = "<div class=\"msg robot\"><div class=\"msg-left\" worker=\"" + user + "\"><div class=\"msg-host photo\" style=\"background-image: url(../images/1.jpg)\"></div><div class=\"msg-ball\" title="+time+">" + content + "</div></div></div>";
    }
    return str;
}