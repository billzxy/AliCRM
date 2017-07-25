<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/19/2017
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false"%>
<html>
<head>
    <meta charset="utf-8">
    <title>成功！</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/rsq.ico"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/rsq.css">
    <style type="text/css">
        body {
            background-image:url(<%=request.getContextPath()%>/images/index-banner.png);
            background-size:2179px 739px;
            background-position: center top;
        }
        h2 {
            line-height: 36px;
            font-size: 24px;
            color: white;
            margin-bottom: 48px;
            font-family: PingFang,"Helvetica Neue",Helvetica,"Hiragino Sans GB","Microsoft YaHei",STHeitiSC-Light,SimHei,"\\5FAEÈíÑÅºÚ",Arial,sans-serif;
            font-weight: 400;
            text-align: center;
        }
        p{
            text-align: center;
            color: white;
            margin-top: 75px;
        }
    </style>
</head>
<body>
    <h2 style="margin-top: 202.5px;">&nbsp;感谢使用日事清:你理想的工作方式</h2>
    <h2 style="margin-top: 75.5px;">&nbsp;信息添加成功，我们将尽快完成验证，并为您创建账户</h2>
    <div class="bottomLine"><p class="toReg">日事清官方网站</p></div>
    <script type="text/javascript">
        $(".toReg").click(function () {
            window.location.href="http://www.rishiqing.com/"
        })
    </script>
</body>
</html>
