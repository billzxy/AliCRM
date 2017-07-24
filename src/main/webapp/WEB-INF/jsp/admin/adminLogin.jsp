<%@ page import="com.rishiqing.AliyunCRM.model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/20/2017
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>登录</title>
    <link rel="shortcut icon" href="/images/rsq.ico"/>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <!--<script type="text/javascript" src="/script/loginAuth.js"></script>-->

    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>

</head>
<body>
<!--
    <h2>管理员登录界面</h2>
    <div>
        <p>账号：</p><input id="user" type="text" name="user">
        <p>密码：</p><input id="pass" type="password" name="pass">
        <button id="login">登录</button>
    </div>
    -->
    <div id="login-box">
        <h2>管理员登录界面</h2>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <form name='loginForm'
              action="<c:url value='j_spring_security_check' />" method='POST'>

            <table>
                <tr>
                    <td>用户名:</td>
                    <td><input type='text' name='user' value=''></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input type='password' name='pass' /></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit"
                                           value="登录" /></td>
                </tr>
            </table>
            <a href="/">返回</a>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />

        </form>
    </div>

</body>
</html>
