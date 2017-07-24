<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/21/2017
  Time: 11:01 AM
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
<h2>无效的页码，请重试！</h2>
<a href="<%=request.getContextPath()%>/adminCustomerInfo">返回</a>
</body>
</html>
