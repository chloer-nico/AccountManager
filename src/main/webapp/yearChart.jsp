<%@ page import="cn.hutool.log.StaticLog" %><%--
  Created by IntelliJ IDEA.
  User: dhx
  Date: 2020/11/22
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>年度账单统计</title>
    <script src="res/jquery/jquery.min.js"></script>
    <script src="res/highcharts/highcharts.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/login.css"/>
</head>
<body>
<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
<script language="JavaScript">
    $(document).ready(function() {
        var chart = {
            type: 'column'
        };
        var title = {
            text: '年度账单统计'
        };
        // X轴坐标轴信息
        var xAxis = {
            categories: ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],
            crosshair: true
        };
        //Y轴坐标轴信息
        var yAxis = {
            min: 0,
            title: {
                text: '人民币（元）'
            }
        };
        //提示信息,第一个参数时当前月份，第二个是柱状的名字，第三个是值
        var tooltip = {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 元</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        };
        var plotOptions = {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        };
        var credits = {
            enabled: false
        };
        //数据，一共两根柱
        <%
            double[] income=(double[]) session.getAttribute("arrayIncome");
            double[] expense=(double[]) session.getAttribute("arrayExpense");
//            StaticLog.info("expense[11]:"+expense[11]);
            request.setAttribute("exp1",expense[1]);request.setAttribute("exp2",expense[2]);request.setAttribute("exp3",expense[3]);
            request.setAttribute("exp4",expense[4]);request.setAttribute("exp5",expense[5]);request.setAttribute("exp6",expense[6]);
            request.setAttribute("exp7",expense[7]);request.setAttribute("exp8",expense[8]);request.setAttribute("exp9",expense[9]);
            request.setAttribute("exp10",expense[10]);request.setAttribute("exp11",expense[11]);request.setAttribute("exp12",expense[12]);

            request.setAttribute("inc1",income[1]);request.setAttribute("inc2",income[2]);request.setAttribute("inc3",income[3]);
            request.setAttribute("inc4",income[4]);request.setAttribute("inc5",income[5]);request.setAttribute("inc6",income[6]);
            request.setAttribute("inc7",income[7]);request.setAttribute("inc8",income[8]);request.setAttribute("inc9",income[9]);
            request.setAttribute("inc10",income[10]);request.setAttribute("inc11",income[11]);request.setAttribute("inc12",income[12]);
        %>
        var series= [{
            name: '支出',
            data: [${exp1}, ${exp2}, ${exp3}, ${exp4},${exp5}, ${exp6},
                ${exp7}, ${exp8}, ${exp9}, ${exp10}, ${exp11}, ${exp12}]
        }, {
            name: '收入',
            data: [${inc1}, ${inc2}, ${inc3}, ${inc4}, ${inc5}, ${inc6},
                ${inc7}, ${inc8}, ${inc9}, ${inc10}, ${inc11}, ${inc12}]
        }];

        var json = {};
        json.chart = chart;
        json.title = title;
        json.tooltip = tooltip;
        json.xAxis = xAxis;
        json.yAxis = yAxis;
        json.series = series;
        json.plotOptions = plotOptions;
        json.credits = credits;
        $('#container').highcharts(json);

    });
</script>
<table align="center">
    <tr><td><input type="button" value="返回" class="btn" onclick="window.location.href='center.jsp'"></td></tr>
</table>

</body>
</html>
