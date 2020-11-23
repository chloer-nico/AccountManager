<%@ page import="cn.hutool.log.StaticLog" %><%--
  Created by IntelliJ IDEA.
  User: dhx
  Date: 2020/11/22
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>账单统计图</title>
    <script src="res/jquery/jquery.min.js"></script>
    <script src="res/highcharts/highcharts.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/login.css"/>
</head>
<body>
<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
<script language="JavaScript">
    $(document).ready(function() {
        var chart = {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false

        };
        //标题
        var title = {
            text: '账单统计图'
        };
        //提示信息，当移动到该区域时显示名字
        var tooltip = {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        };

        //函数配置
        var plotOptions = {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        };
        //首先获取上一个页面的money数组
        <%
        double money[]=(double[]) session.getAttribute("arrayMoney");
        StaticLog.info("money[1]:"+money[1]);
        StaticLog.info("moneySize"+money.length);
        %>
        //数据
        // 1.日用
        // 2.交通
        // 3.旅行
        // 4.娱乐
        // 5.服饰
        // 6.餐饮
        // 7.社交
        // 8.学习
        var series= [{
            type: 'pie',
            name: '账单统计图',
            data: [//名字和占比
                ['日用',<%=money[1]%>],
                ['交通',<%=money[2]%>],
                ['旅行',<%=money[3]%>],
                ['娱乐',<%=money[4]%>],
                ['服饰',<%=money[5]%>],
                //默认选择餐饮
                {
                    name: '餐饮',
                    y: <%=money[6]%>,
                    //默认分片
                    sliced: true,
                    //默认选中该项
                    selected: true
                },
                ['社交',<%=money[7]%>],
                ['学习',<%=money[8]%>]
            ]
        }];
        //创建json数据
        var json = {};
        json.chart = chart;
        json.title = title;
        json.tooltip = tooltip;
        json.series = series;
        json.plotOptions = plotOptions;
        //使用json格式来配置
        $('#container').highcharts(json);
    });
</script>
<table align="center">
    <tr><td><input type="button" value="返回" class="btn" onclick="window.location.href='center.jsp'"></td></tr>
</table>
</body>
</html>
