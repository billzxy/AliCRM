/**
 * Created by 117_John on 7/19/2017.
 */
var data=[];

var dataCount;
var showMax=10;
var onPage="1";
var pageCount;
var isPageBarReady=false;



$(document).ready(function getPageCount(){
    $.ajax({
        url:"/getCustomerCount",
        type:"GET",
        dataType:"text",
        timeout:60000,
        error: function (data) {alert("获取客户信息失败！");},
        success: function (result) {
            dataCount = result;;
            showPageBar();
            getData();
        }
    });
    $("#submit_search").click(
        function () {
            
        }
    )
});


function showPageBar(){
    pageCount = Math.ceil(dataCount/showMax);
    for(var i=1;i<=pageCount;i++){
        var pageN='<li class=""><a href="#" id="'+i+'">'+" "+i+" "+'</a></li>';
        $('#page').append(pageN);
    }
}

function showPage(){
    $('#page li a').click(function() {
            if (isPageBarReady) {
                var selectPage = $(this).attr('id');
                $("#page li").each(function () {
                    $(this).attr("class", "");
                });
                $(this).parent().attr("class", "active");
                $('#customerTable tbody').empty();
                onPage=$(this).attr('id');
                isPageBarReady=false;
                getData();
            }
        }
    );
}


function getData(){
    var pageRequest = {
        "page": onPage,
        "max":showMax
    };

    $.ajax(
        {
            url:"/getCustomer",
            type:"POST",
            data:JSON.stringify(pageRequest),
            contentType:"application/json",
            dataType:"text",
            timeout:60000,
            error: function (data) {alert("获取客户信息失败！"+data);},
            success: function (result) {
                var customerMap = JSON.parse(result);
                if(customerMap.totalCount===0){
                    //$("#msg").html("无用户信息");
                }else{
                    $('#customerTable tbody').empty();
                    var listOfCustomer = customerMap.data;
                    for(var  i=0;i<listOfCustomer.length;i++) {
                        var rsqLicense = getRsqLicense(listOfCustomer[i].license);
                        var customerStatus = getStatus(listOfCustomer[i].status);
                        var tr = "<tr>" +
                            "<td>"+listOfCustomer[i].name+"</td>" +
                            "<td>"+listOfCustomer[i].phoneNo+"</td>" +
                            "<td>"+listOfCustomer[i].emailAdd+"</td>" +
                            "<td>"+rsqLicense+"</td>" +
                            "<td>"+customerStatus+"</td>" +
                            "<td><a href="+"/customer?id="+listOfCustomer[i].id+">详情</a> </td>" +
                            "</tr>";
                        $('#customerTable tbody').append(tr);
                    }
                    isPageBarReady=true;
                    showPage();
                }
            }
        });
}


function getStatus(status){
    if(status===0){
        return "未处理";
    }else if(status===1) {
        return "已提交至销售部";
    }else if(status===2){
        return "已激活";
    }else if(status===3){
        return "其他";
    }else{
        return "无处理状态";
    }
}

function getRsqLicense(license){
    if(license===0){
        return "未记录";
    }else if(license===1) {
        return "专业版";
    }else if(license===2){
        return "企业版";
    }else if(license===3){
        return "旗舰版";
    }else{
        return "无版本记录";
    }
}

