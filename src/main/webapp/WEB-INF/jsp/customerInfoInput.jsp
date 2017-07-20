<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/19/2017
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>日事清客户信息录入</title>
    <!--TODO：封装jquery-->
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.js"></script>
    <script type="text/javascript" src="/script/customerInfoInput.js"></script>
</head>
<body>
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
    <div><a href="/login">管理员登录</a></div>
    <div>
        <p>联系我们：<a href="http://www.rishiqing.com/">日事清</a></p>
    </div>
    <!--TODO:加些联系信息 链接到日事清官网-->
</body>
</html>
