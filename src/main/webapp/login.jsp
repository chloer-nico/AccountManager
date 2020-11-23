<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/17
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        body {
            background-image: url("./images/login/1.jpeg");;
            background-size: 100%;
            background-repeat: no-repeat;
        }
    </style>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/Login.js"></script>

</head>
<body>
<h1 id="logo_frame"><b>小猪管账</b></h1>
<div id="login_frame">

    <p id="image_logo"><img src="./images/icon1.PNG"/></p>

    <form action="LogCheck">

        <p><label class="label_input">手机号</label><input type="text" name="tel" class="text_field"/></p>
        <p><label class="label_input">密码</label><input type="password" name="password" class="text_field"/></p>
        <%--        <p><input type="button" value="还没有账号去注册" onclick="window.location.href='register.jsp'"></p>--%>
        <p><input type="button" class="btn" value="登录" onclick="login()"/></p>
        <%--        <a id="forget_pwd" href="forget_pwd.html">忘记密码？</a>--%>
        <a id="forget_pwd" href="register.jsp">还没有账号去注册</a>
    </form>
</div>
</body>
</html>
