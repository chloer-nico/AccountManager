<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/21
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息界面</title>
    <script language="JavaScript" src="../js/registercheck.js" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="../css/register.css"/>
</head>
<body>
<h1 id="logo_frame"><b>小猪管账</b></h1>
<div id="login_frame">

    <form action="../UpdateUser">

        <p><label class="label_input">用户名</label><input type="text" name="userName" class="text_field" value="<%=session.getAttribute("sessionName")%>"/></p>
        <p><label class="label_input">手机号</label><input type="text" name="userTel" class="text_field" value="<%=session.getAttribute("sessionTel")%>"/></p>
        <p><label class="label_input">修改密码</label><input type="password" name="userPassword" class="text_field" /></p>
        <p><label class="label_input">确认密码</label><input type="password" placeholder="请再次输入密码" name="userPassword2" class="text_field" /></p>
        <br>
        <p><input type="button" class="btn" value="修改" onclick="registerCheck()"/>
            <input type="reset" class="btn" name="reset"   value="重置"/>
        </p>
<%--        <a id="register" href="login.jsp">返回登录</a>--%>
    </form>
</div>
</body>
</html>
