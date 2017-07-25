<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/19/2017
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false"%>
<html>
<head>
    <meta charset="utf-8">
    <title>阿里云市场日事清新用户注册</title>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/rsq.ico"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/script/customerInfoInput.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/rsq.css">
    <style>
        .bottomLine{
            margin-bottom: 100px;
        }
    </style>
</head>
<body>
<header class="mainHeader">
    <div class="logo"></div>
    <img class="wave" src="<%=request.getContextPath()%>/images/waveBg.png">
</header>
<div class="mainContainer">

<div class="container showing" id="loginView">
    <h3>欢迎使用日事清！</h3>
    <div class="posR user">
        <i class="iconUser"></i>
        <ul class="searchResult" style="display: none;"></ul>
        <input id="name_input" type="text" class="popInput" placeholder="输入您的用户名（不得包含符号）">
    </div>
    <div class="posR psw">
    <i class="iconPhone"></i>
    <ul class="searchResult" style="display: none;"></ul>
    <input id="phone_input" type="text" class="popInput" placeholder="输入您的手机号">
    </div>
    <div class="posR psw">
        <i class="iconEmail"></i>
        <ul class="searchResult" style="display: none;"></ul>
        <input id="email_input" type="text" class="popInput" placeholder="输入您的邮箱">
    </div>

    <div class="posR psw">
        <i class="iconPsw"></i>
        <ul class="searchResult" style="display: none;"></ul>
        <input id="code_input" type="text" class="popInput" placeholder="输入您的阿里云验证码">
    </div>
    <div class="posR psw">
        <i class="iconYzm"></i>
        <input id="note_input" type="text" class="popInput" placeholder="输入备注信息（选填）">
    </div>

    <div class="errorPlace"></div>
    <div class="btn" id="submitButton">提交注册</div>


    <div class="bottomLine"><span class="toReg">日事清官方网站</span></div>


</div>
</div>
<!--
    <h2>欢迎使用日事清</h2>
    <h3>请输入您的个人信息和阿里云验证码</h3>
        <ul id="customer_list">
            <li>用户名（长度1~8个汉字/1~16个字符，不得包含符号）： <input id="name_input" type="text" name="name">*</li>
            <li>手机/电话号码： (大陆 +86）  <input id="phone_input" type="text" name="phoneNo">*</li>
            <li>邮箱： <input id="email_input" type="text" name="emailAdd">*</li>
            <li>验证码：    <input id="code_input" type="text" name="verificationCode">*</li>
            <li>备注信息（长度小于30个汉字/60个字符，不得包含符号）：   <input id="note_input" type="text" name="note"></li>
            <p>* 为必填项目</p>
            <button type="button" id="submitButton">提交</button>
        </ul>
    <div><a href="<%=request.getContextPath()%>/login">管理员登录</a></div>
    <div>
        <p>日事清官方网站：<a href="http://www.rishiqing.com/">日事清</a></p>
    </div>
    -->
</body>
</html>
