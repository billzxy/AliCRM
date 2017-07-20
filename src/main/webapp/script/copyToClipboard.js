/**
 * Created by 117_John on 7/20/2017.
 */
$(document).ready(function () {
    $("button.js-copy").click(function () {
        var btn = document.getElementById($(this).attr("id"));
        var clipboard = new Clipboard(btn);//实例化

        //复制成功执行的回调，可选
        clipboard.on('success', function () {
            alert("复制成功！");
        })

        //复制失败执行的回调，可选
        clipboard.on('error', function () {
                alert("复制失败！");
            }
        )
    });
    $("button.historyBack").click(
        function () {
            history.back(1);
            history.go(-1);
        }
    )
});