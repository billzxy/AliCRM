<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/19/2017
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false"%>

<html>
<head>
    <meta charset="utf-8">
    <title>失败！</title>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/rsq.ico"/>
</head>
<body>
    <h2>信息添加失败，请重试！</h2>
    <a href="<%=request.getContextPath()%>/registration">返回</a>
</body>
</html>
