function accountCheck(){

    let money=document.forms[0].money.value;
    let reg0=/^-?[0-9]{1,5}([\.][0-9]{1,2})?$/;
    let ok=false;

    if(!reg0.test(money)){
        alert("单次记录金额不能超过五位数且最多保留两位小数");
    }

    else
        ok=true;
    if(ok)
        document.forms[0].submit();
}