/**
 * Created by 117_John on 7/19/2017.
 */
var length;
var data=[];

//var $tbody = $("#customerTable");

$(document).ready(function(){
    //$("#customerTable tr").hide();
        $.ajax(
            {
                url:"/getAllCustomers",
                type:"GET",
                dataType:"text",
                timeout:60000,
                error: function (data) {alert("获取客户信息失败！"+data);},
                success: function (result) {
                    var customerMap = JSON.parse(result);
                    length = customerMap.totalCount;
                    if(length===0){
                        //$("#msg").html("无用户信息");
                    }else{
                        var dataList=[];
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
                            data.push(tr);
                        }
                        showPageNavi()
                    }

                }
            });

});

function showPageNavi() {
    var Count = data.length;//记录条数
    var PageSize=5;//设置每页示数目
    var PageCount=Math.ceil(Count/PageSize);//计算总页数
    var currentPage =1;//当前页，默认为1。
    //造个简单的分页按钮

    for(var i=1;i<=PageCount;i++){
        var pageN='<li class=""><a href="#" id="'+i+'" >'+" "+i+" "+'</a></li>';
        $('#page').append(pageN);
    }

    //显示默认页（第一页）
    for(i=(currentPage-1)*PageSize;i<PageSize*currentPage;i++){
        $('#customerTable tbody').append(data[i]);
    }
    //显示选择页的内容
    $('a').click(function(){
        var selectPage=$(this).attr('id');
        $("#page li").each(function (){
            $(this).attr("class","");
        });
        $(this).parent().attr("class","active");
        $('#customerTable tbody').html('');
        for(i=(selectPage-1)*PageSize;i<PageSize*selectPage;i++){
            $('#customerTable tbody').append(data[i]);
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

