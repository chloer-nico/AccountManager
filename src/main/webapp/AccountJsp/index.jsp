<%--suppress ReferencesToClassesFromDefaultPackagesInJSPFile --%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="examples.Account" %>
<%@ page import="cn.hutool.log.StaticLog" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/20
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示查询的账单信息</title>
    <meta charset="UTF-8" />
    <script src="../res/jquery/jquery.min.js"></script>
    <script src="../res/highcharts/highcharts.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/login.css"/>
</head>

<body>
<h1 id="logo_frame"><b>小猪管账</b></h1>
<br>
<h1 align="center">账户收支目录</h1>

<div id="chart_frame">
    <br>
    <table align="center" width="720">

        <tr><td class="chart_input" width="120">AccountId
            <td class="chart_input" width="120">Time
            <td class="chart_input" width="120">Type
            <td class="chart_input" width="120">Money
            <td class="chart_input" width="120">Remark
            <td class="chart_input" width="120">Methods</td>
        </tr>
        <%
            List<Account> list= (List<Account>) session.getAttribute("sessionList");
            //用来为下一个页面存储每个类型的账单总金额
            double money[]=new double[9];
            //循环显示
            for(Account account:list){
                switch (account.getType()){
                    case "日用":money[1]+=account.getMoney();break;
                    case "交通":money[2]+=account.getMoney();break;
                    case "旅行":money[3]+=account.getMoney();break;
                    case "娱乐":money[4]+=account.getMoney();break;
                    case "服饰":money[5]+=account.getMoney();break;
                    case "餐饮":money[6]+=account.getMoney();break;
                    case "社交":money[7]+=account.getMoney();break;
                    case "学习":money[8]+=account.getMoney();break;
                }
                //设置传递的参数字符串
                request.setAttribute("strAccountId",account.getAccountId());
                request.setAttribute("strUserId",account.getUserId());
                request.setAttribute("strMoney",account.getMoney());
                request.setAttribute("strTime",account.getTime());
                request.setAttribute("strRemark",account.getRemark());

        %>
        <tr>
            <td class="chart_field"><%=account.getAccountId()%></td>
            <td class="chart_field"><%=account.getTime()%></td>
            <td class="chart_field"><%=account.getType()%></td>
            <td class="chart_field"><%=account.getMoney()%></td>
            <td class="chart_field"><%=account.getRemark()%></td>
            <td class="chart_field">
                <%--            为修改界面传递参数并跳转--%>
                <a href='${pageContext.request.contextPath}/AccountJsp/alterAccount.jsp?
            &accountId=${strAccountId}
            &userId=${strUserId}
            &money=${strMoney}
            &time=${strTime}
            &remark=${strRemark}
            '>修改</a>
                <a href='DeleteAccount?
               &accountId=${strAccountId}
            '>删除</a>
            </td>
        </tr>
        <%}
            //为图表页面传递money数组
            session.setAttribute("arrayMoney",money);
        %>
    </table>
    <br>
    <p><input type="button" class="btn" value="显示饼图" onclick="window.location.href='pieChart.jsp'"/></p>
</div>
</body>
</html>
