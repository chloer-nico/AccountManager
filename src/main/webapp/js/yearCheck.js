//检查输入的年份是否合格
function yearCheck(){
    let check=/^[0-9]{4}$/
    let year=document.forms[0].year.value;

    if(!check.test(year)){
        alert("请输入四位数字！");
    }
    else {
        document.forms[0].submit();
    }
}