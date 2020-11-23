<%--
  Created by IntelliJ IDEA.
  User: dhx
  Date: 2020/11/22
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择待统计的年份</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script language="JavaScript" src="js/yearCheck.js" charset="utf-8"></script>
</head>
<body>
<h1 id="logo_frame"><b>小猪管账</b></h1>
<div id="login_frame">
    <form action="QueryYearAccount">

        <br>

        <p><label class="label_input">选择年份</label>
            <input class="text_field" type="text" name="year" placeholder="格式yyyy"></p >
        <br>
        <p><input type="button" class="btn" value="确定" onclick="yearCheck()"/></p >
        <p><input type="button" class="btn" value="返回" onclick="window.location.href='center.jsp'"></p >

    </form>
</div>
</body>
</html>
