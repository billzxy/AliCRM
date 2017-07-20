<%--
  Created by IntelliJ IDEA.
  User: 117_John
  Date: 7/20/2017
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript" src="/js/clipboard.min.js"></script>
<html>
<head>
    <title>客户信息:${name}</title>

</head>
<body>
    <h2>客户详细信息：</h2>
    <ul>
        <li>姓名： ${name}<button id="b1" class="js-copy" data-clipboard-text="${name}">点击复制</button></li>
        <li>Email地址： ${emailAdd}<button id="b2" class="js-copy" data-clipboard-text="${emailAdd}">点击复制</button></li>
        <li>手机号： ${phoneNo}<button id="b3" class="js-copy" data-clipboard-text="${phoneNo}">点击复制</button></li>
        <li>验证码： ${verificationCode} <button id="b4" class="js-copy" data-clipboard-text="${verificationCode}">点击复制</button> </li>
        <li>日事清版本： ${license}</li>
        <li>处理状态： ${status}</li>
        <li>注册日期： ${dateCreated}</li>
        <li>客户备注： ${note}</li>
        <li>管理员备注： ${adminNote}</li>

    </ul>
</body>
</html>

<script type="text/javascript">
    $(document).ready(function () {
        $("button.js-copy").click(function () {
            var btn = document.getElementById($(this).attr("id"));
            var clipboard = new Clipboard(btn);//实例化

            //复制成功执行的回调，可选
            clipboard.on('success', function (e) {
                alert("复制成功！");
            })

            //复制失败执行的回调，可选
            clipboard.on('error', function (e) {
                    alert("复制失败！");
                }
            )
        })
    });
</script>
