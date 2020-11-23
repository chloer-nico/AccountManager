function registerCheck(){

var name=document.forms[0].userName.value;
var tel=document.forms[0].userTel.value;
var pwd=document.forms[0].userPassword.value;
var pwd1=document.forms[0].userPassword2.value;
var reg0=/^[0-9]{8,16}$/;
var reg2=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
<!--reg2密码-->
var reg4 = /[\u4e00-\u9fa5\u4dae\uE863]/;

if(!reg4.test(name)) alert("姓名格式错误");

else if(!reg2.test(pwd)) alert("密码长度长度不能小于6且不大于20 同时包含数字和字母");
else if(pwd!=pwd1) alert("两次密码输入不一致");
else document.forms[0].submit();
}