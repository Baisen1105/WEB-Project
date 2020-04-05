var btn_login = $("#btn_login");
var user = $("#user");
var pwd = $("#pwd");
var flag = false;

//普通员工登录
    btn_login.addEventListener('click',function(){
        // check_submit();
        // if(flag==true) {
            ajax({
                url: 'http://localhost:8080/login/compare',
                type: 'post',
                data: {
                    user_id: user.value,
                    password: pwd.value,
                },
                datatype: 'json',
                success: function (ret) {
                    console.log(ret);
                    if(ret == 'success'){
                        window.location.href = "/login/success"
                        return
                    }
                    else {
                        window.location.href = "/login/failed"
                        return;
                    }
                },
                error: function () {

                    alert("服务器错误");
                }
            })
        // }
    })

function $(str) {
    return document.querySelector(str);
}
function ajax(opts) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200 || xhr.status === 304) {
                var result = xhr.responseText;
                opts.success(result);
            } else {
                opts.error();
            }
        }
    }
    var query = "?";
    for (var key in opts.data) {
        query += key + "=" + opts.data[key] + "&"
    }
    xhr.open(opts.type, opts.url + query, true)
    xhr.send()
}