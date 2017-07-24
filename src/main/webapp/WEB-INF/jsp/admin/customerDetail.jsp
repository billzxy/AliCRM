<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/20/2017
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="true"%>
<%String path = request.getContextPath();%>

<html>
<head>
    <link rel="shortcut icon" href="<%=path%>/images/rsq.ico"/>
    <script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/clipboard.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/copyToClipboard.js"></script>
    <script type="text/javascript" src="<%=path%>/script/modifyCustomerInfo.js"></script>
    <title>客户信息:${name}</title>
    <meta name="csrf-token" content="${_csrf.token}">
    <meta name="csrf-name" content="${_csrf.parameterName}">
</head>
<body>
    <h2>客户详细信息：</h2>
    <div id="modifyButton"><button id="modifyInfo">修改客户信息</button></div>
    <ul>
        <li>姓名： ${name}<button id="b1" class="js-copy" data-clipboard-text="${name}" >点击复制</button></li>
        <li>Email地址： ${emailAdd}<button id="b2" class="js-copy" data-clipboard-text="${emailAdd}">点击复制</button></li>
        <li>手机号： ${phoneNo}<button id="b3" class="js-copy" data-clipboard-text="${phoneNo}">点击复制</button></li>
        <li>验证码： ${verificationCode} <button id="b4" class="js-copy" data-clipboard-text="${verificationCode}">点击复制</button></li>
        <li>日事清版本： ${license}  <select id="license_selection" name="rsqLicense">
            <option disabled="disabled" value="4">(选择日事清版本)</option>
            <option value="1">专业版</option>
            <option value="2">企业版</option>
            <option value="3">旗舰版</option>
            <option value="0">未记录</option>
        </select></li>
        <li>处理状态： ${status} <select id="status_selection" name="status">
            <option disabled="disabled" value="4">(选择处理状态)</option>
            <option value="1">提交至销售</option>
            <option value="2">已激活</option>
            <option value="3">其他</option>
            <option value="0">未处理</option>
        </select></li>
        <li>注册日期： ${dateCreated}            </li>
        <li>客户备注： ${note}                   </li>
        <li>管理员备注： ${adminNote}</li>
    </ul>
    <textarea id="admin_note" rows="3" cols="30" placeholder="请输入备注"></textarea>
    <div id="saveButton"><button id="saveInfo">保存修改</button></div>
    <button id="goBack">返回</button>
</body>
</html>
