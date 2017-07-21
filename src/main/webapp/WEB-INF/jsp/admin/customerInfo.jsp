<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/19/2017
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <link rel="shortcut icon" href="/images/rsq.ico"/>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <!--  BOOTSTRAP -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <!--  PAGINATION plugin -->
    <link rel="stylesheet" type="text/css" href="/css/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="/js/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="/js/localization/en.min.js"></script>

    <script type="text/javascript" src="/script/pageNavi.js"></script>
</head>
<body>
    <h2>阿里云客户列表：</h2>
    <div>
        <p id="search">搜索：
            <input id="name_search" type="text" name="name" maxlength="16" placeholder="输入姓名">
            <input id="email_search" type="email" name="emailAdd" placeholder="输入Email">
            <input id="phone_search" type="number" name="phoneNo" maxlength="11" placeholder="输入电话">
            <input id="code_search" type="text" name="verificationCode" placeholder="输入验证码">
            <select id="license_selection"name="rsqLicense">
                <option value="1">专业版</option>
                <option value="2">企业版</option>
                <option value="3">旗舰版</option>
                <option value="0">未记录</option>
            </select>
            <button id="submit_search">搜索</button>
        </p>
    </div>
    <div id="naviBar">

        <table class="table table-hover" id="customerTable">
            <caption>客户列表</caption>
            <thead>
                <tr>
                    <th>姓名</th>
                    <th>手机号</th>
                    <th>Email地址</th>
                    <th>日事清版本</th>
                    <th>处理状态</th>
                    <th>详情</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>

        <ul class="pagination" id="page"> </ul>
    </div>
</body>
</html>
