<%@ page import="cn.hutool.core.date.DateTime" %>
<%@ page import="cn.hutool.core.date.DateUtil" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/19
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <%--    <script language="JavaScript" src="registercheck.js" charset="utf-8"></script>--%>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<%--<%--%>
<%--    //获取当前系统时间,返回的是DateTime类型，但只用date类型--%>
<%--    Date date= DateUtil.date();--%>
<%--    //只获取年和月--%>
<%--    SimpleDateFormat str1=new SimpleDateFormat("yyyy");--%>
<%--    String year=str1.format(date);--%>
<%--    String month=str1.format(date);--%>
<%--%>--%>
<h1 id="logo_frame"><b>小猪管账</b></h1>
<div id="login_frame">
    <br>
    <table align="center" valign="middle">
        <tr>
            <td class="label_input">用户名</td>
            <td id="name" class="text_field"><%=session.getAttribute("sessionName")%></td>
        </tr>
        <tr></tr>
        <tr><td class="label_input">手机号</td>
            <td id="tel" class="text_field"><%=session.getAttribute("sessionTel")%></td>
        </tr>
        <tr></tr>
        <tr><td class="label_input">VIP</td>
            <td id="password" class="text_field"><%=session.getAttribute("sessionVip")%></td>
        </tr>
    </table>
    <br>
    <p><input type="button" class="btn" value="新增一条账单" onclick=window.location.href="./AccountJsp/addAccount.jsp">
        <input type="button" class="btn" value="修改个人信息" onclick="window.location.href='./UserJsp/alterUser.jsp'"/></p>
    <p><input type="button" class="btn"  value="查看账户信息" onclick=window.location.href="./AccountJsp/query.jsp">

        <input type="button" class="btn" value="年度账单统计" onclick=window.location.href="yearChoose.jsp"></p>
    <%--        <a id="forget_pwd" href="agreement.html">用户协议</a>--%>

    <a id="forget_pwd" href="login.jsp">退出</a>

</div>
</body>
</html>
