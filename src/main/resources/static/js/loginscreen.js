function sub() //按钮点击时调用的函数
{
    $.ajax({
        type: "post", //固定方法主要看接口
        url: "#", //请求的链接
        contentType: 'application/json',
        data: JSON.stringify({
            "name": $('#').value, //定制化数据，可以从输入框获取$('#').value
            "password": $('#').value
        }),
        success: function(returndata) {
            var flag = false;
            var input_code = document.getElementById('vcode').value;
            console.log(returndata) //成功后执行的命令
            if (returndata == 'ok' && flag == true) {
                alert("登陆成功")
                window.location.href = "web1mainpage.html";
            } else {
                if (flag == false) {
                    alert("验证失败! ")
                    return;
                }
                alert("用户名或密码错误! ")
            }
        },
        error: function(e) {
            alert("服务器响应错误");
        }
    })
}