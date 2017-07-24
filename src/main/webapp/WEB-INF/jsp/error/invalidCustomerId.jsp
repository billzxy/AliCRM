<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/20/2017
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false"%>

<html>
<head>
    <title>失败！</title>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/rsq.ico"/>
</head>
<body>
<h2>无效的客户信息，请重试！</h2>
<a href="<%=request.getContextPath()%>/adminCustomerInfo">返回</a>
</body>
</html>
