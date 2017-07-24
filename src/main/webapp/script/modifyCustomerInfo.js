/**
 * Created by 117_John on 7/24/2017.
 */

var isSaved = true;


$(document).ready(function () {
    $("#saveButton").hide();
    $("#license_selection").hide();
    $("#status_selection").hide();
    $("#admin_note").hide();

    $("#modifyInfo").click(function () {
       isSaved = false;
       $("#modifyButton").hide();
       $("#saveButton").show();
       $("#license_selection").show();
       $("#status_selection").show();
       $("#admin_note").show();

    });

    $("#saveInfo").click(function () {
        var license = $("#license_selection").val();
        var status = $("#status_selection").val();
        var adminNote = $("#admin_note").val();
        var dataMap = {
            "id":getParameterByName("id"),
            "rsqLicense":license,
            "status":status,
            "adminNote":adminNote
        }

        $.ajaxSetup({
            headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            }
        });
        $.ajax({
            url:"modify",
            type:"POST",
            data:JSON.stringify(dataMap),
            contentType:"application/json;charset=utf-8",
            dataType:"text",
            timeout:60000,
            error: function (data) {alert("保存客户信息失败！");},
            success: function (result) {
                isSaved = true;
                hideItemsAfterSaved();
                alert("保存成功");
                location.reload();
            }
        })
    });

    $("#goBack").click(function () {
        if(!isSaved){
            var exitDecision = confirm("尚未保存修改,是否确定离开？");
            if(exitDecision){
                window.location.href="adminCustomerInfo";
            }else{
                return ;
            }
        }else{
            window.location.href="adminCustomerInfo";
        }
    })
});

function hideItemsAfterSaved() {
    $("#modifyButton").show();
    $("#saveButton").hide();
    $("#license_selection").hide();
    $("#status_selection").hide();
    $("#admin_note").hide();
}
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}