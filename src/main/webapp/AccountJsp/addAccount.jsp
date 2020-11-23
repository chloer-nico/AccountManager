<%@ page import="cn.hutool.log.StaticLog" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/21
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加一条收支</title>
    <script language="JavaScript" src="../js/account.js" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="../css/login.css"/>
</head>
<body>
<h1 id="logo_frame"><b>小猪管账</b></h1>
<div id="login_frame">

    <%--    <p id="image_logo"><img src="./images/icon1.PNG"/></p>--%>

    <form action="../AddAccount">

        <p><label class="label_input">日期</label><input type="date" id="idTime" name="time" class="text_field"/></p>
        <p><label class="label_input">类型</label>
            <select name="type" class="text_field">
                <option value ="日用" selected>日用</option>
                <option value ="交通">交通</option>
                <option value="旅行">旅行</option>
                <option value="娱乐">娱乐</option>
                <option value="服饰">服饰</option>
                <option value="餐饮">餐饮</option>
                <option value="社交">社交</option>
                <option value="学习">学习</option>
                <option value="收入">收入</option>
            </select>
        </p>
        <p><label class="label_input">金额</label><input type="text" name="money" class="text_field" placeholder="7位有效数字，2位小数"/></p>
        <p><label class="label_input">备注</label>
            <textarea class="text_field" name="remark" rows="4" cols="30"></textarea></p>
        <br>
        <p><input type="button" class="btn" value="确认" onclick="accountCheck()"/>
            <input type="reset" class="btn" value="重置"/>
        </p>
    </form>
</div>

</body>
</html>
