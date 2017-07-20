/**
 * Created by 117_John on 7/20/2017.
 */
$(document).ready(function () {
    $("#login").click(function () {
        var user = $("#user").val();
        var pass = $("#pass").val();
        if(user==="admin"&&pass==="admin"){
            window.location.href="/adminCustomerInfo";
        }else{
            alert("用户名密码错误！");
        }
    });
});