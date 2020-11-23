<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/21
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%--选择待查询的日期，查询账单以及统计饼图--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择日期查询</title>
    <link rel="stylesheet" type="text/css" href="../css/login.css"/>
</head>
<body>
<h1 id="logo_frame"><b>小猪管账</b></h1>
<div id="login_frame">
    <br>
    <br>
    <form action="../QueryAccount">
        <br>
        <p><label class="label_input">开始日期</label>
            <input class="text_field" type="date" name="beginDate" value="选择开始日期"></p>

        <p><label class="label_input">结束日期</label>
            <input type="date" name="endDate" value="选择结束日期" class="text_field"></p>
        <br>
        <input type="submit" class="btn" value="查询账单">
    </form>
</div>
</body>
</html>
