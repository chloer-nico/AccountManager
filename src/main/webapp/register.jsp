<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/17
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script language="JavaScript" src="js/registercheck.js" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="css/register.css"/>
<%--    <script type="text/javascript" src="register.js"></script>--%>
</head>
<body>
<h1 id="logo_frame"><b>小猪管账</b></h1>
<div id="login_frame">

<%--    <p id="image_logo"><img src="./images/icon1.PNG"/></p>--%>

    <form action="InsertUser">

        <p><label class="label_input">用户名</label><input type="text" name="userName" class="text_field"/></p>
        <p><label class="label_input">手机号</label><input type="text" name="userTel" class="text_field"/></p>
        <p><label class="label_input">密码</label><input type="password" name="userPassword" class="text_field" placeholder="中英混合 至少六位"/></p>
        <p><label class="label_input">确认密码</label><input type="password" placeholder="请再次输入密码" name="userPassword2" class="text_field"/></p>
        <br>
        <p><input type="button" class="btn" value="注册" onclick="registerCheck()"/>
            <input type="reset" class="btn" name="reset"   value="取消"/></td>
        </p>
        <a id="forget_pwd" href="agreement.html">用户协议</a>

        <a id="register" href="login.jsp">返回登录</a>
    </form>
</div>
</body>
</html>
