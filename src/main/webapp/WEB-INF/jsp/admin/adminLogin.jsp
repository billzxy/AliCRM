<%@ page import="com.rishiqing.AliyunCRM.model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/20/2017
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/script/loginAuth.js"></script>
</head>
<body>
    <h2>管理员登录界面</h2>
    <div>
        <p>账号：</p><input id="user" type="text" name="user">
        <p>密码：</p><input id="pass" type="password" name="pass">
        <button id="login">登录</button>
    </div>
</body>
</html>
