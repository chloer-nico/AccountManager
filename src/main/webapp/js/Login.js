/**
 * 输入验证
 */
function login() {


    let tel = document.forms[0].tel.value;
    let pass= document.forms[0].password.value;
    let ok=false;

    let numCheck = /^[0-9]*$/;

    if (tel.length!=11) {
        alert("手机号必须为11位！");
    }
    else if (pass.length<=0) {
        alert("请输入密码");
    }
    else if(!numCheck.test(tel)){
        alert("手机号必须为纯数字！");
    }
    else{
        ok=true;
    }
    if(ok){
        document.forms[0].submit();
    }
}
/*
*  var id=document.forms[0].login_id.value;
    var reg0=/^[0-9]{8,16}$/;
    if(id.length<=0) alert("账号不能为空");
    if(!reg0.test(id)) alert("账号格式错误");
    else document.forms[0].submit();*/