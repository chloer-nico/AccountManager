<%@ page import="cn.hutool.log.Log" %>
<%@ page import="java.io.Console" %>
<%@ page import="cn.hutool.log.StaticLog" %><%--
  Created by IntelliJ IDEA.
  User: dhx
  Date: 2020/11/21
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提示信息</title>
</head>
<body>
<%
    //获取信息响应码
//    String code= (String) session.getAttribute("infoCode");
    String code= (String) request.getAttribute("infoCode");
    StaticLog.info("infoCode",code);
    if(code.equals("1")){//1为用户不存在
%>
<script language = "javascript" >
    alert("不存在该用户!");
    location.href = "login.jsp";
</script>
<%
    }
    //2表示密码错误
    else if(code.equals("2")) {%>
<script language = "javascript" >
                alert("密码错误!");
        location.href = "login.jsp";
</script>
<%
    }//3表示注册成功
    else if(code.equals("3")){%>
<script language = "javascript" >
    alert("注册成功!");
    location.href = "login.jsp";
</script>
<%
    }//4表示注册失败
    else if(code.equals("4")){%>
<script language = "javascript" >
    alert("用户已存在!请登录!");
    location.href = "login.jsp";
</script>
<%
    }//5表示更新用户失败,返回信息更新页面
    else if(code.equals("5")){%>
<script language = "javascript" >
    alert("更新用户信息失败！请确认信息格式！");
    location.href = "center.jsp";
</script>
<%
    }//6表示更新成功，返回登录界面
    else if(code.equals("6")){%>
<script language = "javascript" >
    alert("更新用户信息成功！请重新登录！");
    location.href = "login.jsp";
</script>
<%
    }
    //7表示向account表增加数据成功
    else if(code.equals("7")){%>
<script language = "javascript" >
    alert("添加账单成功！");
    location.href = "center.jsp";
</script>
<%
    }
    //8表示向account表增加数据失败
    else if(code.equals("8")){%>
<script language = "javascript" >
    alert("添加失败！请确认信息格式！");
    location.href = "center.jsp";
</script>
<%
    }
    //9表示更新account数据成功
    else if(code.equals("9")){%>
<script language = "javascript" >
    alert("更新account数据成功！");
    location.href = "center.jsp";
</script>
<%
    }
    //10表示更新account数据失败
    else if(code.equals("10")){%>
<script language = "javascript" >
    alert("更新account数据失败！请确认信息格式！");
    location.href = "center.jsp";
</script>
<%
    }
    //11表示删除数据成功
    else if(code.equals("11")){%>
<script language = "javascript" >
    alert("删除account数据成功！");
    location.href = "center.jsp";
</script>
<%
    }
    //12表示删除数据失败
    else if(code.equals("12")){%>
<script language = "javascript" >
    alert("删除account数据失败！");
    location.href = "center.jsp";
</script>
<%
    }
%>
</body>
</html>
