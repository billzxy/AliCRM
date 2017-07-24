/**
 * Created by 117_John on 7/19/2017.
 */
var name;
var phone;
var email;
var code;
var note;
$(document).ready(function(){
    $("#submitButton").click(function () {
        $("#submitButton").attr("disabled",true);
        getInputs();
        var areInputsChecked = checkInputs();
        if(areInputsChecked){
            if(note.length>0) {
                submitInfoWithNote();
            }else{
                submitInfo()
            }
        }
    });
});

function submitInfoWithNote() {
    var dataJson = {
        "name":name,
        "emailAdd":email,
        "phoneNo":phone,
        "verificationCode":code,
        "note":note
    };
    $.ajax(
        {
            url:"saveInfoWNote",
            type:"POST",
            data:JSON.stringify(dataJson),
            contentType:"application/json",
            dataType:"text",
            timeout:60000,
            error:function () {alert("通讯失败，请重试");},
            success:function (data) {
                if(data==="ok"){
                    redirectSuccess();
                }else{
                    redirectFailed();
                }
            }
        }
    )
}
function submitInfo(){
    var dataJson = {
        "name":name,
        "emailAdd":email,
        "phoneNo":phone,
        "verificationCode":code
    };
    $.ajax(
        {
            url:"saveInfo",
            type:"POST",
            data:JSON.stringify(dataJson),
            contentType:"application/json",
            dataType:"text",
            timeout:60000,
            error:function () {alert("通讯失败，请重试");},
            success:function (data) {
                if(data==="ok"){
                    redirectSuccess();
                }else{
                    redirectFailed();
                }
            }
        }
    )
}
function redirectSuccess(){
    window.location.replace("finished");
}
function redirectFailed() {
    window.location.replace("addFail")
}

function getInputs() {
    name = $("#name_input").val();
    phone = $("#phone_input").val();
    email = $("#email_input").val();
    code = $("#code_input").val();
    note = $("#note_input").val();
}

function checkInputs() {
    if(!checkName()){
        alert("用户名不符合规范，请输入正确的用户名！");
        return false;
    }
    if(!checkPhone()){
        alert("手机/电话号码不符合规范，请输入正确的手机/电话号码！");
        return false;
    }
    if(!checkEmail()){
        alert("邮箱地址不符合规范，请输入正确的邮箱地址！");
        return false;
    }
    if(!checkCode()){
        alert("验证码错误，请输入正确的验证码！");
        return false;
    }
    if(!checkNote()){
        alert("备注包含非法字符，请重新输入！");
        return false;
    }
    return true;
}
var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
function checkName(){
    if(name.length>16||name.length===0){
        return false;
    }
    return !pattern.test(name);
}
function checkPhone(){
    //var reg= /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
    //return reg.test(phone);TODO:REGEX here
    if(phone.length<10||phone.length>11){
        return false;
    }
    return /^[0-9]*$/.test(phone);
}

function checkEmail() {
    var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    return reg.test(email);
}
function checkCode(){
    if(code.length===0){
        return false;
    }
    return !pattern.test(code);
}
function checkNote(){
    if(note.length>60){
        return false;
    }
    return !pattern.test(note);
}
