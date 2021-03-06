<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/19/2017
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="csrf-token" content="${_csrf.token}">
    <meta name="csrf-name" content="${_csrf.parameterName}">
    <title>日事清阿里云市场注册用户</title>
    <link rel="shortcut icon" href="<%=path%>/images/rsq.ico"/>
    <script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
    <!--  BOOTSTRAP -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
    <!--  PAGINATION plugin -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/localization/en.min.js"></script>

    <script type="text/javascript" src="<%=path%>/script/pageNavi.js"></script>
</head>
<body>
    <style type="text/css">
        h3 {
            float: right;
        }
    </style>
    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <!-- csrt for log out-->
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3>
            管理员账号 | <a
                href="javascript:formSubmit()"> 登出</a>
        </h3>
    </c:if>
    <h2>阿里云客户列表：</h2>

    <div id="search">
        <p>搜索:
            <div>
            <input id="name_search" type="text" name="name" maxlength="16" placeholder="输入姓名">
            <input id="email_search" type="email" name="emailAdd" placeholder="输入Email">
            <input id="phone_search" type="text" name="phoneNo" maxlength="11" placeholder="输入电话">
            <input id="code_search" type="text" name="verificationCode" placeholder="输入验证码">
            <select id="license_selection" name="rsqLicense">
                <option value="4">(选择日事清版本)</option>
                <option value="1">专业版</option>
                <option value="2">企业版</option>
                <option value="3">旗舰版</option>
                <option value="0">未记录</option>
            </select>
        <select id="status_selection" name="status">
            <option value="4">(选择处理状态)</option>
            <option value="1">提交至销售</option>
            <option value="2">已激活</option>
            <option value="3">其他</option>
            <option value="0">未处理</option>
        </select>
            <button id="submit_search_button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                搜索
            </button>

        显示<input id="search_max" type="number" min="1" max="30" placeholder="10" value="10">条搜索结果
            </div>

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            搜索结果：
                        </h4>
                    </div>
                    <div id="search_result" class="modal-body">
                        <table class="table table-hover" id="searchResultTable">
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
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
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
